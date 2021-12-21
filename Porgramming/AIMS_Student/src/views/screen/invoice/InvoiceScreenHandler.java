package views.screen.invoice;

import common.exception.ProcessInvoiceException;
import controller.PaymentController;
import entity.invoice.Invoice;
import entity.order.OrderMedia;
import entity.order.RushOrder;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.payment.PaymentScreenHandler;

/**
 * This is the class handler for invoice screen.
 * <br>@author ADMIN
 *
 */
public class InvoiceScreenHandler extends BaseScreenHandler {

  private static Logger LOGGER = Utils.getLogger(InvoiceScreenHandler.class.getName());

  @FXML
  private Label pageTitle;

  @FXML
  private Label name;

  @FXML
  private Label phone;

  @FXML
  private Label province;

  @FXML
  private Label address;

  @FXML
  private Label instructions;

  @FXML
  private Label subtotal;

  @FXML
  private Label shippingFees;

  @FXML
  private Label total;

  @FXML
  private VBox vboxItems;

  private Invoice invoice;

  /**
   * This is the constructor for the class InvoiceScreenHandler. 
   * <br>@param stage
   * <br>@param screenPath
   * <br>@param invoice
   * <br>@throws IOException
   */
  public InvoiceScreenHandler(Stage stage, String screenPath, 
      Invoice invoice) throws IOException {
    super(stage, screenPath);
    this.invoice = invoice;
    setInvoiceInfo();
  }

  @SuppressWarnings("unchecked")
  private void setInvoiceInfo() throws IOException {
    HashMap<String, String> deliveryInfo = invoice.getOrder().getDeliveryInfo();
    name.setText(deliveryInfo.get("name"));
    province.setText(deliveryInfo.get("province"));
    instructions.setText(deliveryInfo.get("instructions"));
    address.setText(deliveryInfo.get("address"));
    subtotal.setText(Utils.getCurrencyFormat(invoice.getOrder().getAmount()));
    shippingFees.setText(Utils.getCurrencyFormat(invoice.getOrder().getShippingFees()));
    int amount = invoice.getOrder().getAmount() + invoice.getOrder().getShippingFees();
    total.setText(Utils.getCurrencyFormat(amount));
    invoice.setAmount(amount);
    if (invoice.getOrder() instanceof RushOrder) {
      try {
        RushOrder order = new RushOrder(invoice.getOrder().getlstOrderMedia());
        
        AnchorPane pane = new AnchorPane();
        HBox hbox = new HBox();
        Label label = new Label("Media shipped as usual");
        hbox.getChildren().add(label);
        pane.getChildren().add(hbox);
        
        
        order.getListMediaNotSupportRushOrder().forEach(orderMedia -> {
          try {
            MediaInvoiceScreenHandler mis = new MediaInvoiceScreenHandler(
                Configs.INVOICE_MEDIA_SCREEN_PATH);
            mis.setOrderMedia((OrderMedia) orderMedia);
            vboxItems.getChildren().add(mis.getContent());
          } catch (IOException | SQLException e) {
            System.err.println("errors: " + e.getMessage());
            throw new ProcessInvoiceException(e.getMessage());
          } 
        });
        
        order.getListMediaSupportRushOrder().forEach(orderMedia -> {
          try {
            MediaInvoiceScreenHandler mis = new MediaInvoiceScreenHandler(
                Configs.INVOICE_MEDIA_SCREEN_PATH);
            mis.setOrderMedia((OrderMedia) orderMedia);
            vboxItems.getChildren().add(mis.getContent());
          } catch (IOException | SQLException e) {
            System.err.println("errors: " + e.getMessage());
            throw new ProcessInvoiceException(e.getMessage());
          } 
        });
        
      } catch (Exception e) {
        System.err.println("errors: " + e.getMessage());
        throw new ProcessInvoiceException(e.getMessage());
      }
      
    } else {
        
      invoice.getOrder().getlstOrderMedia().forEach(orderMedia -> {
        try {
          MediaInvoiceScreenHandler mis = new MediaInvoiceScreenHandler(
              Configs.INVOICE_MEDIA_SCREEN_PATH);
          mis.setOrderMedia((OrderMedia) orderMedia);
          vboxItems.getChildren().add(mis.getContent());
        } catch (IOException | SQLException e) {
          System.err.println("errors: " + e.getMessage());
          throw new ProcessInvoiceException(e.getMessage());
        }

      });
      
    }

  }

  @FXML
  void confirmInvoice(MouseEvent event) throws IOException {
    BaseScreenHandler paymentScreen = new PaymentScreenHandler(this.stage, 
        Configs.PAYMENT_SCREEN_PATH, invoice);
    paymentScreen.setbController(new PaymentController());
    paymentScreen.setPreviousScreen(this);
    paymentScreen.setHomeScreenHandler(homeScreenHandler);
    paymentScreen.setScreenTitle("Payment Screen");
    paymentScreen.show();
    LOGGER.info("Confirmed invoice");
  }

}

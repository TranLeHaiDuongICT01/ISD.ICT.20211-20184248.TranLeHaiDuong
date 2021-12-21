package views.screen.shipping;

import common.exception.InvalidDeliveryInfoException;
import controller.PlaceOrderController;
import controller.PlaceRushOrderController;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.RushOrder;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.invoice.InvoiceScreenHandler;

/**
 * This is class handler for shipping screen.
 * <br>@author ADMIN
 *
 */
public class ShippingScreenHandler extends BaseScreenHandler implements Initializable {

  @FXML
  private Label screenTitle;

  @FXML
  private TextField name;

  @FXML
  private TextField phone;

  @FXML
  private TextField address;

  @FXML
  private TextField instructions;
  
  @FXML
  private RadioButton btn;

  @FXML
  private ComboBox<String> province;

  private Order order;

  public ShippingScreenHandler(Stage stage, String screenPath, Order order) throws IOException {
    super(stage, screenPath);
    this.order = order;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    final BooleanProperty firstTime = new SimpleBooleanProperty(true);
    // Variable to store the focus on stage load
    name.focusedProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue && firstTime.get()) {
        content.requestFocus(); // Delegate the focus to container
        firstTime.setValue(false); // Variable value changed for future references
      }
    });
    this.province.getItems().addAll(Configs.PROVINCES);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @FXML
  void submitDeliveryInfo(MouseEvent event) throws IOException, InterruptedException, SQLException {

    // add info to messages
    HashMap messages = new HashMap<>();
    messages.put("name", name.getText());
    messages.put("phone", phone.getText());
    messages.put("address", address.getText());
    messages.put("instructions", instructions.getText());
    messages.put("province", province.getValue());
    messages.put("rush order", String.valueOf(btn.isSelected()));
    PlaceOrderController controller;
    if (btn.isSelected()) {
      controller = new PlaceRushOrderController();
      order = new RushOrder(order.getlstOrderMedia());
    } else {
      controller = getbController();
    }
    try {
      // process and validate delivery info
      controller.processDeliveryInfo(messages);
    } catch (InvalidDeliveryInfoException e) {
      throw new InvalidDeliveryInfoException(e.getMessage());
    }

    // calculate shipping fees
    int shippingFees = controller.calculateShippingFee(order);
    order.setShippingFees(shippingFees);
    order.setDeliveryInfo(messages);

    // create invoice screen
    Invoice invoice = controller.createInvoice(order);
    if (controller instanceof PlaceRushOrderController) {
      System.out.println("Hello");
    } else {
      System.out.println("Bye");
    }
    BaseScreenHandler invoiceScreenHandler = new InvoiceScreenHandler(
        this.stage, Configs.INVOICE_SCREEN_PATH, invoice);
    invoiceScreenHandler.setPreviousScreen(this);
    invoiceScreenHandler.setHomeScreenHandler(homeScreenHandler);
    invoiceScreenHandler.setScreenTitle("Invoice Screen");
    invoiceScreenHandler.setbController(controller);
    invoiceScreenHandler.show();
  }

  public PlaceOrderController getbController() {
    return (PlaceOrderController) super.getbController();
  }
  

  public void notifyError() {
    // TODO: implement later on if we need
  }

}

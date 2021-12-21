package views.screen.invoice;

import entity.order.OrderMedia;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Utils;
import views.screen.FxmlScreenHandler;

/**
 * This is the class handler for screen displaying the media in the invoice.
 * <br>@author ADMIN
 *
 */
public class MediaInvoiceScreenHandler extends FxmlScreenHandler {

  @FXML
  private HBox hboxMedia;

  @FXML
  private VBox imageLogoVbox;

  @FXML
  private ImageView image;

  @FXML
  private VBox description;

  @FXML
  private Label title;

  @FXML
  private Label numOfProd;

  @FXML
  private Label labelOutOfStock;

  @FXML
  private Label price;

  private OrderMedia orderMedia;

  public MediaInvoiceScreenHandler(String screenPath) throws IOException {
    super(screenPath);
  }

  public void setOrderMedia(OrderMedia orderMedia) throws SQLException {
    this.orderMedia = orderMedia;
    setMediaInfo();
  }

  /**
   * This is the method set and restore the media info to display on the screen.
   * <br>@throws SQLException
   */
  public void setMediaInfo() throws SQLException {
    String typeName = "";
    if (!orderMedia.getMedia().isIfSupportRushOrder()) {
      typeName = "(usual ship)";
    } else {
      typeName = "(rush ship)";
    }
    title.setText(orderMedia.getMedia().getTitle() + typeName);
    price.setText(Utils.getCurrencyFormat(orderMedia.getPrice()));
    numOfProd.setText(String.valueOf(orderMedia.getQuantity()));
    setImage(image, orderMedia.getMedia().getImageUrl());
    image.setPreserveRatio(false);
    image.setFitHeight(90);
    image.setFitWidth(83);
  }

}

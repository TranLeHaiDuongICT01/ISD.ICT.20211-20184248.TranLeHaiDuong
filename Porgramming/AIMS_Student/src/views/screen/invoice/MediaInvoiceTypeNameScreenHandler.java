package views.screen.invoice;

import java.awt.Label;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import views.screen.FxmlScreenHandler;

/**
 * This is the class handler for screen displaying the media type name in the invoice.
 * <br>@author ADMIN
 *
 */
public class MediaInvoiceTypeNameScreenHandler extends FxmlScreenHandler {
  
  @FXML
  private HBox hbox;
  
  @FXML
  private Label label;

  public MediaInvoiceTypeNameScreenHandler(String screenPath) throws IOException {
    super(screenPath);
    // TODO Auto-generated constructor stub
  }
  
  public void setText(String text) throws SQLException {
    label.setText(text);
  }

}

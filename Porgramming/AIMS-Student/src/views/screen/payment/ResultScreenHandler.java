package views.screen.payment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

/**
 * This is the class handler for screen displaying result of payment.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("unused")
public class ResultScreenHandler extends BaseScreenHandler {

  private String result;
  private String message;

  /**
   * This is the constructor for the class ResultScreenHandler.
   * <br>@param stage
   * <br>@param screenPath
   * <br>@param result
   * <br>@param message
   * <br>@throws IOException
   */
  public ResultScreenHandler(Stage stage, String screenPath, 
      String result, String message) throws IOException {
    super(stage, screenPath);
    resultLabel.setText(result);
    messageLabel.setText(message);
  }

  @FXML
  private Label pageTitle;

  @FXML
  private Label resultLabel;

  @FXML
  private Button okButton;

  @FXML
  private Label messageLabel;

  @FXML
  void confirmPayment(MouseEvent event) throws IOException {
    homeScreenHandler.show();
  }

}

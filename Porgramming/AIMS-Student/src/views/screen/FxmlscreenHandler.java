package views.screen;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * This is the parent class handler for other class handler to extend.
 * <br>@author ADMIN
 *
 */
public class FxmlscreenHandler {

  protected FXMLLoader loader;
  protected AnchorPane content;

  /**
   * This is the constructor for the class FxmlscreenHandler.
   * <br>@throws IOException  @{@link java.io.IOException}
   */
  public FxmlscreenHandler(String screenPath) throws IOException {
    this.loader = new FXMLLoader(getClass().getResource(screenPath));
    // Set this class as the controller
    this.loader.setController(this);
    this.content = (AnchorPane) loader.load();
  }

  public AnchorPane getContent() {
    return this.content;
  }

  public FXMLLoader getLoader() {
    return this.loader;
  }

  /**
   * This is the method to set image from path link.
   * <br>@param imv  the oponent ImageView to set image into
   * <br>@param path  the path link to the image
   */
  public void setImage(ImageView imv, String path) {
    File file = new File(path);
    Image img = new Image(file.toURI().toString());
    imv.setImage(img);
  }
}

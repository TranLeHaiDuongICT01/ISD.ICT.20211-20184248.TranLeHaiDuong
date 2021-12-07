package views.screen;

import controller.BaseController;
import java.io.IOException;
import java.util.Hashtable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.screen.home.HomeScreenHandler;

/**
 * This is the class hanlder for base screen.
 * <br>@author ADMIN
 *
 */
public class BaseScreenHandler extends FxmlscreenHandler {

  private Scene scene;
  private BaseScreenHandler prev;
  protected final Stage stage;
  protected HomeScreenHandler homeScreenHandler;
  protected Hashtable<String, String> messages;
  private BaseController baseController;

  private BaseScreenHandler(String screenPath) throws IOException {
    super(screenPath);
    this.stage = new Stage();
  }

  public void setPreviousScreen(BaseScreenHandler previousScreen) {
    this.prev = previousScreen;
  }

  public BaseScreenHandler getPreviousScreen() {
    return this.prev;
  }

  public BaseScreenHandler(Stage newStage, String screenPath) throws IOException {
    super(screenPath);
    this.stage = newStage;
  }

  /**
   * This is the method to show the screen.
   */
  public void show() {
    if (this.scene == null) {
      this.scene = new Scene(this.content);
    }
    this.stage.setScene(this.scene);
    this.stage.show();
  }

  public void setScreenTitle(String string) {
    this.stage.setTitle(string);
  }

  public void setbController(BaseController newBaseController) {
    this.baseController = newBaseController;
  }

  public BaseController getbController() {
    return this.baseController;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void forward(Hashtable message) {
    this.messages = message;
  }

  public void setHomeScreenHandler(HomeScreenHandler homeScreenHandler) {
    this.homeScreenHandler = homeScreenHandler;
  }

}

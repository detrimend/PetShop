import javafx.scene.Scene;
import view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import model.PetShopModel;
import model.PetShopModelManager;

/**
 * Main application class for the Pet Shop application.
 * It initializes the primary stage and starts the view handler.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class MyApplication extends Application
{
  /**
   * Starts the JavaFX application by setting up the primary stage.
   *
   * @param primaryStage the primary stage for this application
   */
  public void start(Stage primaryStage)
  {
    PetShopModel petShopModel = new PetShopModelManager();
    ViewHandler view = new ViewHandler(petShopModel);
    view.start(primaryStage);
  }
}
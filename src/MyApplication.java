import view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import model.PetShopModel;
import model.PetShopModelManager;

public class MyApplication extends Application

{
  public void start(Stage primaryStage)
  {
    PetShopModel petShopModel = new PetShopModelManager();
    ViewHandler view = new ViewHandler(petShopModel);
    view.start(primaryStage);
  }

}
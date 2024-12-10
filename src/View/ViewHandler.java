package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.PetShopModel;

public class ViewHandler
{
  private PetShopModel petShopModel;
  private Scene currentScene;
  private Stage primaryStage;
  private AddAnimalV2ViewController addAnimalV2ViewController;
  private AnimalListeV2ViewController animalListeV2ViewController;
  private AnimalSaleConfirmV2ViewController animalSaleConfirmV2ViewController;
  private CustomerListV2ViewController customerListV2ViewController;
  private ViaCareV2ViewController viaCareV2ViewController;
  private ViaPetNewCustomerV2ViewController viaPetNewCustomerV2ViewController;
  private ViapetSaleV2ViewController viapetSaleV2ViewController;
  private ViaPetsForsideViewController viaPetsForsideViewController;

  public ViewHandler(PetShopModel petShopModel)
  {
    this.currentScene= new Scene(new Region());
  }
  public void start(Stage primaryStage)
  {
    this.primaryStage= primaryStage;
    openView();
  }
  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "list":
        root = load

    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }
  private Region loadSimpleGUIView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.<Region> load();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

}



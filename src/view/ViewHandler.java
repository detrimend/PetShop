package view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.PetShopModel;

import java.io.IOException;

public class ViewHandler
{
  private PetShopModel petShopModel;
  private Scene currentScene;
  private Stage primaryStage;
  private AddAnimalViewController addAnimalViewController;
  private AnimalListViewController animalListViewController;
  private AnimalSaleConfirmViewController animalSaleConfirmV2ViewController;
  private CustomerListViewController customerListViewController;
  private VIACareViewController viaCareViewController;
  private VIAPetNewCustomerViewController viaPetNewCustomerViewController;
  private VIAPetSaleViewController viaPetSaleViewController;
  private VIAPetForsideViewController viaPetForsideViewController;

  public ViewHandler(PetShopModel petShopModel)
  {
    this.currentScene= new Scene(new Region());
    this.petShopModel = petShopModel;
  }
  public void start(Stage primaryStage)
  {
    this.primaryStage= primaryStage;
    openView("forside");
  }
  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "forside":
        root = loadForsideView("VIAPetForside.fxml");
        break;
      case  "AddAnimal":
        root = loadAddAnimalView("AddAnimal.fxml");
        break;
      case "AnimalList":
        root= loadAnimalListView("AnimalList.fxml");
        break;
      case "AnimalSale":
        root= loadAnimalSaleView("AnimalSaleConfirm.fxml");
        break;
      case "CustomerList":
        root= loadCustomerListView("CustomerList.fxml");
        break;
      case "Care":
        root= loadViaCareView("VIACare.fxml");
        break;
      case "NewCustomer":
        root= loadNewCustomerView("VIAPetNewCustomer.fxml");
        break;
      case  "Sale":
        root = loadSaleView("VIAPetSale.fxml");
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + id);
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
  private Region loadForsideView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      VIAPetForsideViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }
  private Region loadAddAnimalView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      AddAnimalViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  private Region loadAnimalListView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }
  private Region loadAnimalSaleView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }
  private Region loadCustomerListView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

  private Region loadViaCareView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

  private Region loadNewCustomerView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      VIAPetNewCustomerViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  private Region loadSaleView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }
}



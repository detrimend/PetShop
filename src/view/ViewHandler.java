package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.PetShopModel;

import java.io.IOException;

/**
 * Handler class for managing views in the Pet Shop application.
 * It handles the loading and switching between different views.
 * This class is responsible for initializing and displaying the views.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class ViewHandler
{
  private PetShopModel petShopModel;
  private Scene currentScene;
  private Stage primaryStage;
  private AnimalViewModel animalViewModel;
  private CustomerViewModel customerViewModel;
  private AnimalListViewModel animalListViewModel;
  private CustomerListViewModel customerListViewModel;
  private AddAnimalViewController addAnimalViewController;
  private AnimalListViewController animalListViewController;
  private AnimalSaleConfirmViewController animalSaleConfirmV2ViewController;
  private CustomerListViewController customerListViewController;
  private VIACareViewController viaCareViewController;
  private VIAPetNewCustomerViewController viaPetNewCustomerViewController;
  private VIAPetSaleViewController viaPetSaleViewController;
  private VIAPetForsideViewController viaPetForsideViewController;
  private AnimalInCareViewController inCareViewController;

  /**
   * Constructs a ViewHandler with the specified model.
   *
   * @param petShopModel the model to interact with the data
   */
  public ViewHandler(PetShopModel petShopModel)
  {
    this.currentScene= new Scene(new Region());
    this.petShopModel = petShopModel;
    this.customerListViewModel = new CustomerListViewModel(petShopModel);
  }

  /**
   * Starts the view handler by setting up the primary stage.
   *
   * @param primaryStage the primary stage for this application
   */
  public void start(Stage primaryStage)
  {
    this.primaryStage= primaryStage;
    openView("forside");
  }

  /**
   * Opens the specified view by its ID.
   *
   * @param id the ID of the view to open
   */
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
      case "CareList":
        root = loadInCareView("AnimalInCare.fxml");
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

  /**
   * Loads the Forside view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
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

  /**
   * Loads the Add Animal view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
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

  /**
   * Loads the Animal List view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
  private Region loadAnimalListView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      AnimalListViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the Animal Sale view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
  private Region loadAnimalSaleView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      AnimalSaleConfirmViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the Customer List view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
  private Region loadCustomerListView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      CustomerListViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the VIACare view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
  private Region loadViaCareView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      VIACareViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the New Customer view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
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

  /**
   * Loads the Sale view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
  private Region loadSaleView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      VIAPetSaleViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the In Care view from the specified FXML file.
   *
   * @param fxmlFile the FXML file to load
   * @return the root region of the loaded view
   */
  private Region loadInCareView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      AnimalInCareViewController controller = loader.getController();
      controller.init(this, petShopModel, root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }
}
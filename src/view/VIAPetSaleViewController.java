package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.AnimalForSale;
import model.Customer;
import model.PetShopModel;

import java.io.IOException;

/**
 * Controller class for the VIAPetSale view.
 * It handles the interaction between the view and the model for pet sales.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class VIAPetSaleViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  @FXML private TextField numberSearchField;
  @FXML private TableView<CustomerViewModel> customerTable;
  @FXML private TableColumn<CustomerViewModel, String> nameColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  private FilteredList<CustomerViewModel> filteredCustomers;
  private FilteredList<AnimalViewModel> filteredAnimals;
  @FXML private TextField speciesSearchField;
  @FXML private TextField typeSearchField;
  @FXML private TableView<AnimalViewModel> animalSaleTable;
  @FXML private TableColumn<AnimalViewModel, String> typeColumn;
  @FXML private TableColumn<AnimalViewModel, String> speciesColumn;
  @FXML private TableColumn<AnimalViewModel, Number> priceColumn;
  @FXML private TableColumn<AnimalViewModel, String> extraInfoColumn;
  @FXML private TableColumn<AnimalViewModel, String> extraInfo2Column;
  private CustomerViewModel selectedCustomer;

  /**
   * Initializes the controller with the specified view handler, model, and root region.
   *
   * @param viewHandler  the view handler
   * @param petShopModel the pet shop model
   * @param root         the root region
   */
  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;

    ObservableList<CustomerViewModel> customers = FXCollections.observableArrayList();
    for (int i = 0; i < petShopModel.getNumberOfCustomers(); i++)
    {
      Customer customer = petShopModel.getCustomerByIndex(i);
      customers.add(new CustomerViewModel(customer));
    }
    filteredCustomers = new FilteredList<>(customers, p -> true);
    customerTable.setItems(filteredCustomers);

    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    numberColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPhoneNumberProperty());

    ObservableList<AnimalViewModel> animals = FXCollections.observableArrayList();
    for (int i = 0; i < petShopModel.getNumberOfAnimalsForSale(); i++)
    {
      AnimalForSale animal = petShopModel.getAnimalForSaleByIndex(i);
      animals.add(new AnimalViewModel(animal));
    }
    filteredAnimals = new FilteredList<>(animals, p -> true);
    animalSaleTable.setItems(filteredAnimals);
    typeColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTypeProperty());
    speciesColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSpeciesProperty());
    priceColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPriceProperty());
    extraInfoColumn.setCellValueFactory(
        cellData -> cellData.getValue().getExtraInfoProperty());
    extraInfo2Column.setCellValueFactory(
        cellData -> cellData.getValue().getExtraInfo2Property());

    typeSearchField.setOnAction(event -> searchByType());
    speciesSearchField.setOnAction(event -> searchBySpecies());
    numberSearchField.setOnAction(event -> searchByPhoneNumber());

    customerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    customerTable.getSelectionModel().selectedItemProperty()
        .addListener((obs, oldSelection, newSelection) -> {
          selectedCustomer = newSelection;
        });

    animalSaleTable.getSelectionModel()
        .setSelectionMode(SelectionMode.MULTIPLE);
  }

  /**
   * Searches customers by phone number.
   */
  @FXML private void searchByPhoneNumber()
  {
    String searchText = numberSearchField.getText();
    if (searchText == null || searchText.isEmpty())
    {
      filteredCustomers.setPredicate(customer -> true);
    }
    else
    {
      filteredCustomers.setPredicate(
          customer -> customer.getPhoneNumberProperty().getValue().toString()
              .contains(searchText));
    }
  }

  /**
   * Searches animals by type.
   */
  @FXML private void searchByType()
  {
    String searchText = typeSearchField.getText();
    if (searchText == null || searchText.isEmpty())
    {
      filteredAnimals.setPredicate(animal -> true);
    }
    else
    {
      filteredAnimals.setPredicate(
          animal -> animal.getTypeProperty().getValue().toString()
              .contains(searchText));
    }
  }

  /**
   * Searches animals by species.
   */
  @FXML private void searchBySpecies()
  {
    String searchText = speciesSearchField.getText();
    if (searchText == null || searchText.isEmpty())
    {
      filteredAnimals.setPredicate(animal -> true);
    }
    else
    {
      filteredAnimals.setPredicate(
          animal -> animal.getSpeciesProperty().getValue().toString()
              .contains(searchText.toLowerCase()));
    }
  }

  /**
   * Opens the view to add a new customer.
   */
  @FXML private void addCustomerButton()
  {
    try
    {
      FXMLLoader fxmlLoader = new FXMLLoader(
          getClass().getResource("VIAPetNewCustomer.fxml"));
      Parent root = fxmlLoader.load();
      VIAPetNewCustomerViewController controller = fxmlLoader.getController();
      controller.init(viewHandler, petShopModel, null);

      Stage newStage = new Stage();
      newStage.setTitle("Add Customer");
      newStage.setScene(new Scene(root));
      newStage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Assigns selected animals to the selected customer.
   */
  @FXML private void assignButton()
  {
    if (selectedCustomer == null)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("No Customer Selected");
      alert.setHeaderText(null);
      alert.setContentText(
          "Please select a customer from the customer list before assigning animals.");
      alert.showAndWait();
      return;
    }

    ObservableList<AnimalViewModel> selectedAnimals = animalSaleTable.getSelectionModel()
        .getSelectedItems();

    if (selectedAnimals.isEmpty())
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("No Animals Selected");
      alert.setHeaderText(null);
      alert.setContentText(
          "Please select one or more animals from the animal list.");
      alert.showAndWait();
      return;
    }

    for (AnimalViewModel animals : selectedAnimals)
    {
      int index = animalSaleTable.getItems().indexOf(animals);
      AnimalForSale animal = petShopModel.getAnimalForSaleByIndex(index);

      TextInputDialog dialog = new TextInputDialog("Animal Name");
      dialog.setTitle("Name the Animal");
      dialog.setHeaderText("Naming the Animal");
      dialog.setContentText("Please enter a name for the selected animal:");

      String nameForPurchasedAnimal = dialog.showAndWait()
          .orElse("Unnamed Animal");

      int customerIndex = customerTable.getSelectionModel().getSelectedIndex();
      Customer customer = petShopModel.getCustomerByIndex(customerIndex);

      petShopModel.addNewPurchase(customer, animal, nameForPurchasedAnimal);
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText(
        "The selected animals have been successfully assigned to the customer.");
    alert.showAndWait();

    animalSaleTable.getSelectionModel().clearSelection();
  }

  /**
   * Refreshes the view.
   */
  @FXML private void refreshButton()
  {
    try
    {
      viewHandler.openView("Sale");
    }
    catch (Exception e)
    {
    }
  }

  /**
   * Navigates back to the previous view.
   */
  @FXML private void BackButton()
  {
    try
    {
      viewHandler.openView("forside");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
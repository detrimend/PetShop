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
  @FXML private Button assignButton;
  private CustomerViewModel selectedCustomer;



  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {

    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;

    {
      // Hent listen af kunder fra modellen og lav en FilteredList
      ObservableList<CustomerViewModel> customers = FXCollections.observableArrayList();
      for (int i = 0; i < petShopModel.getNumberOfCustomers(); i++) {
        Customer customer = petShopModel.getCustomerByIndex(i);
        customers.add(new CustomerViewModel(customer));
      }
      filteredCustomers = new FilteredList<>(customers, p -> true);
      customerTable.setItems(filteredCustomers);

      // Bind data til tabel
      customerTable.setItems(filteredCustomers);
      nameColumn.setCellValueFactory(cellData ->
          cellData.getValue().getNameProperty());
      numberColumn.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProperty());
    }
    ObservableList<AnimalViewModel> animals = FXCollections.observableArrayList();
    for (int i = 0; i < petShopModel.getNumberOfAnimalsForSale(); i++) {
      AnimalForSale animal = petShopModel.getAnimalForSaleByIndex(i);
      animals.add(new AnimalViewModel(animal));
    }
    filteredAnimals = new FilteredList<>(animals, p -> true);
    animalSaleTable.setItems(filteredAnimals);
    typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    speciesColumn.setCellValueFactory(cellData -> cellData.getValue().getSpeciesProperty());
    priceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
    extraInfoColumn.setCellValueFactory(cellData -> cellData.getValue().getExtraInfoProperty());
    extraInfo2Column.setCellValueFactory(cellData -> cellData.getValue().getExtraInfo2Property());

    typeSearchField.setOnAction(event -> searchByType());
    speciesSearchField.setOnAction(event -> searchBySpecies());
    numberSearchField.setOnAction(event -> searchByPhoneNumber());
    {
      // Kald din eksisterende kode for at initialisere kundetabellen...

      // Tilføj Single Selection Mode
      customerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

      // Lyt til valg af kunde
      customerTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        selectedCustomer = newSelection;
      });
    }

    {
      // Kald din eksisterende kode for at initialisere dyretabellen...

      // Tilføj Multi Selection Mode
      animalSaleTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
  }

  @FXML
  private void searchByPhoneNumber()
  {
    String searchText = numberSearchField.getText();
    if (searchText == null || searchText.isEmpty())
    {
      filteredCustomers.setPredicate(customer -> true); // Vis alt
    }
    else
    {
      filteredCustomers.setPredicate(customer -> {
        // Filtrer efter telefonnummer
        return customer.getPhoneNumberProperty().getValue().toString()
            .contains(searchText);
      });
    }
  }


  @FXML
  private void searchByType() {
    String searchText = typeSearchField.getText();
    if (searchText == null || searchText.isEmpty()) {
      filteredAnimals.setPredicate(animal -> true); // Vis alt
    } else {
      filteredAnimals.setPredicate(animal -> {
        // Filtrer efter telefonnummer
        return animal.getTypeProperty().getValue().toString().contains(searchText);
      });
    }
  }

  @FXML
  private void searchBySpecies() {
    String searchText = speciesSearchField.getText();
    if (searchText == null || searchText.isEmpty()) {
      filteredAnimals.setPredicate(animal -> true); // Vis alle dyr
    } else {
      filteredAnimals.setPredicate(animal -> {
        // Filtrer baseret på art (species)
        return animal.getSpeciesProperty().getValue().toLowerCase().contains(searchText.toLowerCase());
      });
    }
  }

  @FXML
  private void addCustomerButton() {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VIAPetNewCustomer.fxml"));
      Parent root = fxmlLoader.load();
      VIAPetNewCustomerViewController controller = fxmlLoader.getController();
      controller.init(viewHandler, petShopModel, null); // Bemærk at "Region root" kan sættes til null eller noget relevant

      Stage newStage = new Stage();
      newStage.setTitle("Add Customer");//set titlen
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  @FXML
  private void assignButton() {
    // 1. Kontroller, at en kunde er valgt
    if (selectedCustomer == null) {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("No Customer Selected");
      alert.setHeaderText(null);
      alert.setContentText("Please select a customer from the customer list before assigning animals.");
      alert.showAndWait();
      return;
    }

    // 2. Hent valgte dyr fra dyretabellen
    ObservableList<AnimalViewModel> selectedAnimals = animalSaleTable.getSelectionModel().getSelectedItems();

    if (selectedAnimals.isEmpty()) {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("No Animals Selected");
      alert.setHeaderText(null);
      alert.setContentText("Please select one or more animals from the animal list.");
      alert.showAndWait();
      return;
    }
    // 3. Loop gennem de valgte dyr og tilføj dem til kunden
    for (AnimalViewModel animals : selectedAnimals) {
      // Her antager vi, at animalsViewModel har et indeks eller en reference
      int index = animalSaleTable.getItems().indexOf(animals);
      AnimalForSale animal = petShopModel.getAnimalForSaleByIndex(index);
      // Pop-up eller dialog for at spørge om dyrenavn
      TextInputDialog dialog = new TextInputDialog("Animal Name");
      dialog.setTitle("Name the Animal");
      dialog.setHeaderText("Naming the Animal");
      dialog.setContentText("Please enter a name for the selected animal:");

      // Vent på input
      String nameForPurchasedAnimal = dialog.showAndWait().orElse("Unnamed Animal");

      int customerIndex = customerTable.getSelectionModel().getSelectedIndex();
      Customer customer = petShopModel.getCustomerByIndex(customerIndex);

      // Brug kunden som normalt
      petShopModel.addNewPurchase(customer, animal, nameForPurchasedAnimal);
    }

    // 4. Giv brugeren besked om, at handlingen er gennemført
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("The selected animals have been successfully assigned to the customer.");
    alert.showAndWait();

    // OPTIONAL: Ryd valget i dyrelisten
    animalSaleTable.getSelectionModel().clearSelection();
  }

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

  @FXML
   private void BackButton() {
   try {
     viewHandler.openView("forside");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

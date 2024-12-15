package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Customer;
import model.PetShopModel;

public class VIACareViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  @FXML private TextField numberSearchField;
  @FXML private TableView<CustomerViewModel> customerTable;
  @FXML private TableColumn<CustomerViewModel, String> nameCustomerColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  private FilteredList<CustomerViewModel> filteredCustomers;
  private CustomerViewModel selectedCustomer;
  @FXML private TableView<AnimalViewModel> animalTable;
  @FXML private TableColumn<AnimalViewModel,String> nameAnimalColumn;
  @FXML private TableColumn<AnimalViewModel, String> speciesColumn;

  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
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

    // Bind data til tabel
    customerTable.setItems(filteredCustomers);
    nameCustomerColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    numberColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPhoneNumberProperty());

    {
      // Kald din eksisterende kode for at initialisere kundetabellen...

      // Tilføj Single Selection Mode
      customerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

      // Lyt til valg af kunde
      customerTable.getSelectionModel().selectedItemProperty()
          .addListener((obs, oldSelection, newSelection) -> {
            selectedCustomer = newSelection;
          });
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
  private void CreateButton()
  {
    try {
      viewHandler.openView("CustomerList");
    } catch (Exception e) {
      e.printStackTrace();
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


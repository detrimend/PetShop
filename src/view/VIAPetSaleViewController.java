package view;

import javafx.beans.Observable;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Customer;
import model.CustomerList;
import model.PetShopModel;

import java.io.IOException;

public class VIAPetSaleViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;
  private CustomerListViewModel customerListViewModel;
  @FXML private TextField numberSearchField;
  @FXML private TableView<CustomerViewModel> phoneNumbersTable;
  @FXML private TableColumn<CustomerViewModel, String> nameColumn;
  @FXML private TableColumn<CustomerViewModel, String> phoneColumn;
  private FilteredList<CustomerViewModel> filteredCustomers;

  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root, CustomerListViewModel customerListViewModel)
  {
    this.customerListViewModel = customerListViewModel;
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;

    initializeTable();
    setupSearchFunctionality();
  }

  private void initializeTable()
  {
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    filteredCustomers = new FilteredList<>(customerListViewModel.getList(),
        p -> true); //getList skal udskiftes eller tilføjes til
    phoneNumbersTable.setItems(filteredCustomers);
  }

  private void setupSearchFunctionality()
  {
    numberSearchField.textProperty()
        .addListener((observable, oldValue, newValue) -> {
          filteredCustomers.setPredicate(customerViewModel -> {
            // Hvis feltet er tomt, vis alle kunder
            if (newValue == null || newValue.isEmpty())
            {
              return true;
            }
            // Filtrer på telefonnummer
            return customerViewModel.getPhoneNumberProperty().equals(newValue);
          });
        });
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

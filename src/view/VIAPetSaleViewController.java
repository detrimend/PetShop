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

  }

  @FXML
  private void searchByPhoneNumber() {
    String searchText = numberSearchField.getText();
    if (searchText == null || searchText.isEmpty()) {
      filteredCustomers.setPredicate(customer -> true); // Vis alt
    } else {
      filteredCustomers.setPredicate(customer -> {
        // Filtrer efter telefonnummer
        return customer.getPhoneNumberProperty().getValue().toString().contains(searchText);
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

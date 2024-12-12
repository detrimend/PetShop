package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import model.*;

public class CustomerListViewController
{
  @FXML private TableView<CustomerViewModel> customerListTable;
  @FXML private TableColumn<CustomerViewModel, SimpleStringProperty> nameColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  @FXML private TableColumn<CustomerViewModel, SimpleStringProperty> emailColumn;
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;
  private CustomerListViewModel viewModel;

  public CustomerListViewController()
  {

  }

  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new CustomerListViewModel(petShopModel);

    nameColumn.setCellValueFactory(new PropertyValueFactory<CustomerViewModel, SimpleStringProperty>("name"));
    numberColumn.setCellValueFactory(new PropertyValueFactory<CustomerViewModel, Number>("phone. nr"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<CustomerViewModel, SimpleStringProperty>("email"));

    customerListTable.setItems(viewModel.getList());
  }



  public void reset()
  {
    viewModel.update();
  }

  public Region getRoot()
  {
    return root;
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

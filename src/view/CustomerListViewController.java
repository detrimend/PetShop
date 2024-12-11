package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.PetShopModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TabableView;

public class CustomerListViewController
{
  @FXML private TableView<CustomerViewModel> customerListTable;
  @FXML private TableColumn<CustomerViewModel, String> nameColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  @FXML private TableColumn<CustomerViewModel, String> emailColumn;
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel model;
  private CustomerListViewModel viewModel;

  public CustomerListViewController()
  {

  }

  public void init(ViewHandler viewHandler, PetShopModel model, Region root)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new CustomerListViewModel(model);

    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    numberColumn.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProperty());
    emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());

    customerListTable.setItems(viewModel.getList());
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

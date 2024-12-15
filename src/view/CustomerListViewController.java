package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.PetShopModel;

public class CustomerListViewController
{
  @FXML private TableView<CustomerViewModel> customerListTable;
  @FXML private TableColumn<CustomerViewModel, String> nameColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  @FXML private TableColumn<CustomerViewModel, String> emailColumn;
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

    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    numberColumn.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProperty());
    emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());

    customerListTable.setItems(viewModel.getList());

    // til debug: System.out.println("CustomerListViewController initialized");
  }

  public void reset()
  {
    viewModel.update();

    customerListTable.setItems(viewModel.getList());
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

  @FXML private void removeOldCustomerData()
  {
    try
    {
      petShopModel.removeOldCustomerData();
      viewModel.update();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
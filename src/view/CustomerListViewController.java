package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Customer;
import model.PetShopModel;

/**
 * Controller class for the Customer List view.
 * It handles the interaction between the view and the model for displaying the list of customers.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class CustomerListViewController
{
  @FXML private TableView<CustomerViewModel> customerListTable;
  @FXML private TableColumn<CustomerViewModel, String> nameColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  @FXML private TableColumn<CustomerViewModel, String> emailColumn;
  private @FXML TextField numberSearchField;
  private FilteredList<CustomerViewModel> filteredCustomers;
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;
  private CustomerListViewModel viewModel;

  /**
   * Constructs a CustomerListViewController.
   */
  public CustomerListViewController()
  {
  }

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
    this.viewModel = new CustomerListViewModel(petShopModel);

    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    numberColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPhoneNumberProperty());
    emailColumn.setCellValueFactory(
        cellData -> cellData.getValue().getEmailProperty());

    customerListTable.setItems(viewModel.getList());

    ObservableList<CustomerViewModel> customers = FXCollections.observableArrayList();
    for (int i = 0; i < petShopModel.getNumberOfCustomers(); i++)
    {
      Customer customer = petShopModel.getCustomerByIndex(i);
      customers.add(new CustomerViewModel(customer));
    }
    filteredCustomers = new FilteredList<>(customers, p -> true);
    customerListTable.setItems(filteredCustomers);

    // til debug: System.out.println("CustomerListViewController initialized");
  }

  /**
   * Resets the view by updating the customer list.
   */
  public void reset()
  {
    viewModel.update();
    customerListTable.setItems(viewModel.getList());
  }

  /**
   * Returns the root region.
   *
   * @return the root region
   */
  public Region getRoot()
  {
    return root;
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

  /**
   * Removes old customer data from the model and updates the view.
   */
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
}

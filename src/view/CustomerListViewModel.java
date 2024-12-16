package view;

import javafx.collections.*;
import model.Customer;
import model.PetShopModel;

/**
 * ViewModel class for Customer List.
 * It provides properties for binding customer list data to the view.
 * This class is used to represent a list of customers in the view.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class CustomerListViewModel
{
  private ObservableList<CustomerViewModel> list;
  private PetShopModel model;

  /**
   * Constructs a CustomerListViewModel with the specified model.
   *
   * @param model the model to be represented by this ViewModel
   */
  public CustomerListViewModel(PetShopModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();

    update();
  }

  /**
   * Updates the list of customers.
   */
  public void update()
  {
    list.clear();
    // til debug: System.out.println("CustomerList update() called");
    for (int i = 0; i < model.getNumberOfCustomers(); i++)
    {
      // til debug: System.out.println("Adding customer of index: " + i);
      list.add(new CustomerViewModel(model.getCustomerByIndex(i)));


    }
  }

  /**
   * Returns the list of customers.
   *
   * @return the list of customers
   */
  public ObservableList<CustomerViewModel> getList()
  {
    return list;
  }

  /**
   * Adds a customer to the list.
   *
   * @param customer the customer to be added
   */
  public void add(Customer customer)
  {
    list.add(new CustomerViewModel(customer));
  }

  /**
   * Removes a customer from the list.
   *
   * @param customer the customer to be removed
   */
  public void remove(Customer customer)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(customer.getName())
          && list.get(i).getPhoneNumberProperty().get()
          == customer.getPhoneNumber() && list.get(i).getEmailProperty().get()
          .equals(customer.getEmail()))
      {
        list.remove(i);
        break;
      }
    }
  }
}

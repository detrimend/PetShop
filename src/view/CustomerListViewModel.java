package view;


import javafx.collections.*;
import model.Customer;
import model.CustomerList;
import model.PetShopModel;

public class CustomerListViewModel
{
  private ObservableList<CustomerViewModel> list;
  private PetShopModel model;

  public CustomerListViewModel(PetShopModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

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
  public ObservableList<CustomerViewModel> getList()
  {
    return list;
  }

  public void add(Customer customer)
  {
    list.add(new CustomerViewModel(customer));
  }

  public void remove(Customer customer)
  {
    for ( int i = 0; i < list.size(); i++)
    {
      if(list.get(i).getNameProperty().get().equals(customer.getName()) &&
          list.get(i).getPhoneNumberProperty().get() == customer.getPhoneNumber() &&
          list.get(i).getEmailProperty().get().equals(customer.getEmail()))
      {
        list.remove(i);
        break;
      }
    }
  }
}

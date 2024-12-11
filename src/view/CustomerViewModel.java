package view;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Customer;

public class CustomerViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty phoneNumberProperty;
  private StringProperty emailProperty;

  public CustomerViewModel(Customer customer)
  {
    nameProperty = new SimpleStringProperty(customer.getName().toString());
    phoneNumberProperty = new SimpleIntegerProperty(customer.getPhoneNumber());
    emailProperty = new SimpleStringProperty(customer.getEmail().toString());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }
  public IntegerProperty getPhoneNumberProperty()
  {
    return phoneNumberProperty;
  }
  public StringProperty getEmailProperty()
  {
    return emailProperty;
  }
}
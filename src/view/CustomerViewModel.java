package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Customer;

/**
 * ViewModel class for Customer.
 * It provides properties for binding customer data to the view.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class CustomerViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty phoneNumberProperty;
  private StringProperty emailProperty;

  /**
   * Constructs a CustomerViewModel with the specified customer.
   *
   * @param customer the customer to be represented by this ViewModel
   */
  public CustomerViewModel(Customer customer)
  {
    nameProperty = new SimpleStringProperty(customer.getName().toString());
    phoneNumberProperty = new SimpleIntegerProperty(customer.getPhoneNumber());
    emailProperty = new SimpleStringProperty(customer.getEmail().toString());
  }

  /**
   * Returns the name property.
   *
   * @return the name property
   */
  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  /**
   * Returns the phone number property.
   *
   * @return the phone number property
   */
  public IntegerProperty getPhoneNumberProperty()
  {
    return phoneNumberProperty;
  }

  /**
   * Returns the email property.
   *
   * @return the email property
   */
  public StringProperty getEmailProperty()
  {
    return emailProperty;
  }
}
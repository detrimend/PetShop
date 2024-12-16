package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Class representing a list of customers.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class CustomerList implements Serializable, Iterable<Customer>
{

  private static final long serialVersionUID = 1L;

  private ArrayList<Customer> customers;

  /**
   * Constructs an empty CustomerList.
   */
  public CustomerList()
  {
    this.customers = new ArrayList<>();
  }

  /**
   * Adds a customer to the list with the specified name, email, and phone number.
   *
   * @param name the name of the customer
   * @param email the email of the customer
   * @param phoneNumber the phone number of the customer
   * @throws IllegalArgumentException if the name or email is null, or if the phone number is not a positive integer
   */
  public void addCustomer(Name name, Email email, int phoneNumber)
  {
    if (name == null || email == null)
    {
      throw new IllegalArgumentException("Name and email cannot be null");
    }
    if (phoneNumber <= 0)
    {
      throw new IllegalArgumentException("Phone number must be a positive integer");
    }
    customers.add(new Customer(name, email, phoneNumber));
  }

  /**
   * Adds a customer to the list with the specified first name, last name, email, and phone number.
   *
   * @param firstName the first name of the customer
   * @param lastName the last name of the customer
   * @param email the email of the customer
   * @param phoneNumber the phone number of the customer
   * @throws IllegalArgumentException if the first name, last name, or email is null, or if the phone number is not a positive integer
   */
  public void addCustomer(String firstName, String lastName, Email email, int phoneNumber)
  {
    if (firstName == null || lastName == null || email == null)
    {
      throw new IllegalArgumentException("Name and email cannot be null");
    }
    if (phoneNumber <= 0)
    {
      throw new IllegalArgumentException("Phone number must be a positive integer");
    }
    customers.add(new Customer(firstName, lastName, email, phoneNumber));
  }

  /**
   * Removes a customer from the list.
   *
   * @param customer the customer to remove
   * @throws IllegalArgumentException if the customer is not found in the list or if one or more owned animals are in care
   */
  public void removeCustomer(Customer customer)
  {
    if (!customers.contains(customer))
    {
      throw new IllegalArgumentException("Customer not found in the list");
    }
    for (int i = 0; i < customer.getOwnedAnimals().getAmountOfAnimals(); i++)
    {
      if (customer.getOwnedAnimals().getAnimalByIndex(i).isInCare())
      {
        throw new IllegalArgumentException("Customer cannot be removed because one or more owned animals are in care");
      }
    }
    for (Customer c : customers)
    {
      if (c.equals(customer))
      {
        Name nullName = new Name("null", "null");
        Email nullEmail = new Email("null", "null", "null");
        c.setName(nullName);
        c.setEmail(nullEmail);
        c.setPhoneNumber(0);
      }
    }
  }

  /**
   * Returns the number of customers in the list.
   *
   * @return the number of customers in the list
   */
  public int getNumberOfCustomers()
  {
    return customers.size();
  }

  /**
   * Returns the customer with the specified phone number.
   *
   * @param phoneNumber the phone number of the customer
   * @return the customer with the specified phone number
   * @throws IllegalArgumentException if the phone number is not a positive integer or if the customer is not found
   */
  public Customer getCustomer(int phoneNumber)
  {
    if (phoneNumber <= 0)
    {
      throw new IllegalArgumentException("Phone number must be a positive integer");
    }
    for (Customer customer : customers)
    {
      if (customer.getPhoneNumber() == phoneNumber)
      {
        return customer;
      }
    }
    throw new IllegalArgumentException("Customer with phone number " + phoneNumber + " not found");
  }

  /**
   * Returns the customer at the specified index.
   *
   * @param index the index of the customer
   * @return the customer at the specified index, or null if the index is out of bounds
   */
  public Customer getCustomerByIndex(int index)
  {
    if (index >= 0 && index < customers.size())
    {
      return customers.get(index);
    }
    return null;
  }

  /**
   * Returns the customer who owns the specified animal.
   *
   * @param ownedAnimal the animal owned by the customer
   * @return the customer who owns the specified animal, or null if no customer owns the animal
   */
  public Customer getCustomerByAnimal(OwnedAnimal ownedAnimal)
  {
    for (int i = 0; i < customers.size(); i++)
    {
      OwnedAnimalsList customersAnimals = customers.get(i).getOwnedAnimals();
      for (int j = 0; j < customersAnimals.getAmountOfAnimals(); j++)
      {
        if (customersAnimals.getAnimalByIndex(j).equals(ownedAnimal))
        {
          return ownedAnimal.getOwner();
        }
      }
    }
    return null;
  }

  /**
   * Returns a string representation of the customer list.
   *
   * @return a string representation of the customer list
   */
  @Override public String toString()
  {
    return "CustomerList{" + "customers=" + customers + '}';
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare
   * @return true if this object is the same as the o argument; false otherwise
   */
  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    CustomerList that = (CustomerList) o;
    return Objects.equals(customers, that.customers);
  }

  /**
   * Returns an iterator over the customers in the list.
   *
   * @return an iterator
   */
  @Override
  public Iterator<Customer> iterator() {
    return customers.iterator();
  }
}
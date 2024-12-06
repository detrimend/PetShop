package model;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerList
{
  private ArrayList<Customer> customers;

  public CustomerList()
  {
    this.customers = new ArrayList<>();
  }

  public void addCustomer(Name name, int phoneNumber, Email email)
  {
    customers.add(new Customer(name, email, phoneNumber));
  }

  public Customer removeCustomer(Customer customer)
  {
    customers.remove(customer);
    {
      return customer;
    }
  }

  public int getNumberOfCustomers()
  {
    return customers.size();
  }

  public Customer getCustomer(int phoneNumber)
  {
    for (int i = 0; i < customers.size(); i++)
    {
      if (customers.get(i).getPhoneNumber() == phoneNumber)
      {
        return customers.get(i);
      }
    }
    return null;
  }

  public Customer getCustomerByIndex(int index)
  {
    if (index >= 0 && index < customers.size())
    {
      return customers.get(index);
    }
    return null;
  }

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

  // Genereret toString og equals

  @Override public String toString()
  {
    return "CustomerList{" + "customers=" + customers + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    CustomerList that = (CustomerList) o;
    return Objects.equals(customers, that.customers);
  }
}

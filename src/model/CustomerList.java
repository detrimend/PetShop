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
    if (name == null || email == null) {
      throw new IllegalArgumentException("Name and email cannot be null");
    }
    if (phoneNumber <= 0) {
      throw new IllegalArgumentException("Phone number must be a positive integer");
    }
    customers.add(new Customer(name, email, phoneNumber));
  }

  // I ModelManger skal der tjek på om customer *kan* slettes jf. usecase
  public void removeCustomer(Customer customer)
  {
    if (!customers.contains(customer)) {
      throw new IllegalArgumentException("Customer not found in the list");
    }
    for (int i = 0; i < customer.getOwnedAnimals().getAmountOfAnimals(); i++){
      if (customer.getOwnedAnimals().getAnimalByIndex(i).isInCare()) {
        throw new IllegalArgumentException("Customer cannot be removed because one or more owned animals are in care");
      }
    }
    for(Customer c : customers)
    {
      if (c.equals(customer))
      {
        Name nullName = new Name(null, null);
        Email nullEmail = new Email(null, null, null);
        c.setName(nullName);
        c.setEmail(nullEmail);
        c.setPhoneNumber(0);
      }
    }
  }

  public int getNumberOfCustomers()
  {
    return customers.size();
  }

  public Customer getCustomer(int phoneNumber)
  {
    if (phoneNumber <= 0) {
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

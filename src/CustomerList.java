import java.util.ArrayList;

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

  public int getCustomer(int phoneNumber)
  {
  for (int i = 0; i < customers.size(); i++)
  {
    if(customers.get(i).getPhoneNumber() == phoneNumber) {
      return i;}
  }
  return -1;
}

  public Customer getCustomerByIndex(int index)
    {
      if(index>= 0 && index < customers.size())
      {
        return customers.get(index);
      }
  return null;
}

  public  Customer getCustomerByAnimal(OwnedAnimal ownedAnimal)
  {
    for( int i = 0; i <customers.size(); i++)
    {
      if (customers.get(i).getOwnedAnimals(ownedAnimal).equals(ownedAnimal))
        return ownedAnimal.getOwner();
    }
    return null;
  }
}

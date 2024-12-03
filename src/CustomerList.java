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

  //: set er ikke blevet implementeret da den kræver instancvariabler at initialiserer

  public void removeCustomer(Customer customer)
  {
    customers.remove(customer);
  }
  //: ret removeCustomer til void


  public int getNumberOfCustomers()
  {
    return customers.size();
  }
  public int getCustomer(int phoneNumber)
  {
  for (int i = 0; i < customers.size(); i++)
  {
    if(customers.get(i).getPhoneNumber() == phoneNumber)
      return i;
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
//: ret til Customer og ret getCustomer til getCustomerByIndex

  public  Customer getCustomerByAnimal(OwnedAnimal animal)
  {
    for( int i = 0; i <customers.size(); i++)
    {
      if (customers.get(i).getOwnedAnimals() == animal)
        return i;
    }
    return null;
  }
}

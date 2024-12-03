public class Customer extends Person
{
  private int phoneNumber;

  public Customer(Name name, Email email, int phoneNumber)
  {
    super(name,email);
    setPhoneNumber(phoneNumber);
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }
  public void setPhoneNumber(int phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }
  public AnimalList getOwnedAnimals()
  {
    return ownedAnimal;
  }

  @Override public String toString()
  {
    return super.toString() + "\n" + "kundens telefonnummer er: " + phoneNumber + "\n" + "kunden ejer følgende dyr" + ownedAnimals;
  }

  public boolean equals(Object obj)
  {
   if(this == obj)
     return true;
   if(obj == null || getClass() != obj.getClass())
     return false;
   Customer customer = (Customer) obj;
   return super.equals(customer) && phoneNumber == customer.phoneNumber;
  }
}

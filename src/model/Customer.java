package model;

public class Customer extends Person
{
  private int phoneNumber;
  private OwnedAnimalsList animals;

  public Customer(Name name, Email email, int phoneNumber)
  {
    super(name, email);
    setPhoneNumber(phoneNumber);
    this.animals = new OwnedAnimalsList();
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber)
  {
    if (phoneNumber <= 0)
    {
      throw new IllegalArgumentException(
          "Phone number must be a positive integer");
    }
    this.phoneNumber = phoneNumber;
  }

  public OwnedAnimalsList getOwnedAnimals()
  {
    return animals;
  }

  public void addOwnedAnimal(OwnedAnimal ownedAnimal)
  {
    animals.addAnimal(ownedAnimal);
  }

  @Override public String toString()
  {
    return super.toString() + "\n" + "kundens telefonnummer er: " + phoneNumber
        + "\n" + "kunden ejer følgende dyr" + getOwnedAnimals().toString();
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Customer customer = (Customer) obj;
    return super.equals(customer) && phoneNumber == customer.phoneNumber;
  }
}

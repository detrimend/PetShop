package model;

import java.time.LocalDate;

public class PetShopModelManager implements PetShopModel
{

  private CustomerList customerList;

  public PetShopModelManager()
  {
    this.customerList = new CustomerList();
    customerList.addCustomer(new Name("Bob Builder"),12345678,new Email("Bob","Builder","dk"));
    customerList.addCustomer(new Name("Wendy Helper"),12345679,new Email("Wendy","Builder","dk"));
  }

  @Override public void removeOldCustomerData()
  {
    removeOldCustomerData();
  }

  @Override public boolean addReservation(DateInterval dateInterval,
      Customer customer)
  {
    return addReservation(dateInterval, customer); // måske?
  }

  @Override public void registerAnimalHandover(Reservation reservation)
  {
    registerAnimalHandover(reservation);
  }

  @Override public void removeReservation(int index)
  {
    removeReservation(index);
  }

  @Override public Customer getCustomer(int phoneNumber)
  {
    return customerList.getCustomer(phoneNumber);
  }

  @Override public OwnedAnimalsList getAnimals()
  {
    return getAnimals();
  }

  @Override public int getNumberOfReservations()
  {
    return getNumberOfReservations();
  }

  @Override public Reservation getReservationByPhoneNumber(int phoneNumber)
  {
    return getReservationByPhoneNumber(phoneNumber);
  }

  @Override public Reservation getReservationByName(String name)
  {
    return getReservationByName(name);
  }

  @Override public Reservation CancelReservation(Reservation reservation)
  {
    return CancelReservation(reservation);
  }

  @Override public Reservation endReservation(Reservation reservation)
  {
    return endReservation(reservation);
  }

  @Override public Customer getCustomerByAnimal(Customer customer)
  {
    return getCustomerByAnimal(customer);
  }

  @Override public void addCustomer(String name, String phoneNumber,
      String email)

  {
    String[] split = email.split("@");
    String user = split[0];
    split = split[1].split(".");
    String domain = split[0];
    String host = split[1];
    customerList.addCustomer(new Name(name),Integer.parseInt(phoneNumber),new Email(user,domain,host));
  }

  @Override public void addCustomer(Name name, int phoneNumber, Email email)
  {
   customerList.addCustomer(name,phoneNumber,email);
  }

  @Override public void removeCustomer(Customer customer)
  {
    removeCustomer(customer);
  }

  @Override public void setName()
  {
    setName();
  }

  @Override public void setEmail()
  {
    setEmail();
  }

  @Override public void setPhoneNumber()
  {
    setPhoneNumber();
  }

  @Override public LocalDate getDate()
  {
    return getDate();
  }

  @Override public OwnedAnimal assignAnimalToCustomer(AnimalForSale animal,
      Customer customer, String name)
  {
    return assignAnimalToCustomer(animal, customer, name);
  }

  @Override public AnimalForSale removeAnimal()
  {
    return removeAnimal();
  }

  @Override public void setSalesStatus(boolean isForSale)
  {
    setSalesStatus(isForSale);
  }

  @Override public double getPrice()
  {
    return getPrice();
  }

  @Override public Email getEmail()
  {
    return getEmail();
  }

  @Override public Name getName()
  {
    return getName();
  }

  @Override public Person getPhoneNumber()
  {
    return getPhoneNumber();
  }

  @Override public double setPrice()
  {
    return setPrice();
  }

  @Override public void addAnimal(AnimalForSale animal)
  {
    addAnimal(animal);
  }

  @Override public AnimalsForSaleList getAnimalsByType()
  {
    return getAnimalsByType();
  }

  @Override public AnimalsForSaleList getAnimalsBySpecies()
  {
    return getAnimalsBySpecies();
  }

  @Override public void putInCare()
  {
    putInCare();
  }

  @Override public AnimalInfo getAnimalInfo()
  {
    return getAnimalInfo();
  }

  @Override public void addComment(String comment)
  {
    addComment(comment);
  }

  @Override public void removeFromCare()
  {
    removeFromCare();
  }

  @Override public String getType()
  {
    return getType();
  }

  @Override public Customer getCustomerByIndex(int index)
  {
    return customerList.getCustomerByIndex(index);
  }

  @Override public int getNumberOfCustomers()
  {
    return customerList.getNumberOfCustomers();
  }

}
package model;

import java.time.LocalDate;

public interface PetShopModel
{
  public void removeOldCustomerData();


  // Administrer reservation til dyrepension.

  public boolean addReservation(DateInterval dateInterval, Customer customer);

  void registerAnimalHandover(Reservation reservation);

  public void removeReservation(int index);

  public Customer getCustomer(int phoneNumber); //By phonenumber

  public OwnedAnimalsList getAnimals();

  public int getNumberOfReservations();

  public Reservation getReservationByPhoneNumber(int phoneNumber);

  public Reservation getReservationByName(String name);

  public Reservation CancelReservation(Reservation reservation);

  public Reservation endReservation(Reservation reservation);

  public Customer getCustomerByAnimal(Customer customer);

  // Salg af dyr

  public void addCustomer(Name name, int phoneNumber, Email email);

  public void removeCustomer(Customer customer);

  public void setName();

  void setEmail();

  void setPhoneNumber();

  LocalDate getDate();

  OwnedAnimal assignAnimalToCustomer(AnimalForSale animal, Customer customer, String name);

  AnimalForSale removeAnimal();

  void setSalesStatus(boolean isForSale);

  double getPrice();

  //Administer kunde

  Email getEmail();

  Name getName();

  Person getPhoneNumber();

  //Administrer dyr

  double setPrice();

  void addAnimal(AnimalForSale animal);

  AnimalsForSaleList getAnimalsByType();

  AnimalsForSaleList getAnimalsBySpecies();

  void putInCare();

  AnimalInfo getAnimalInfo();

  void addComment(String comment);

  void removeFromCare();

  String getType();





}


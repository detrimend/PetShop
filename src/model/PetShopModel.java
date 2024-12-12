package model;

import java.io.Serializable;
import java.time.LocalDate;

public interface PetShopModel extends Serializable {
  void removeOldCustomerData();

  void saveAnimalsForSaleList();

  void saveCustomerList();

  // Administrer reservation til dyrepension.

  boolean addReservation(DateInterval dateInterval, Customer customer,
      OwnedAnimalsList animalsToPutInCare);

  void registerAnimalHandover(Reservation reservation);

  void removeReservation(int index);

  Customer getCustomer(int phoneNumber); //By phonenumber

  int getNumberOfReservations();

  Reservation getReservationByPhoneNumber(int phoneNumber);

  Reservation getReservationByName(String name);

  Reservation cancelReservation(Reservation reservation);

  Reservation endReservation(Reservation reservation);

  Customer getCustomerByAnimal(OwnedAnimal animal);

  void addExistingReservation(Reservation reservation);

  // Salg af dyr

  void addCustomer(String firstName, String lastName, String phoneNumber,
      String email);

  void addCustomer(Name name, int phoneNumber, Email email);

  void removeCustomer(Customer customer);

  /*
  Se kommentar til tilsvarende metoder i ModelManager
  public void setName();

  void setEmail();

  void setPhoneNumber();

  LocalDate getDate();

   */

  AnimalForSale removeAnimal(AnimalForSale animal);

  /*
  void setSalesStatus(boolean isForSale);

  double getPrice();

  //Administer kunde

  Email getEmail();

  Name getName();

  Person getPhoneNumber();
  */
  OwnedAnimalsList getAnimalsByCustomer(Customer customer);
  /*
  //Administrer dyr

  double setPrice();
   */

  OwnedAnimalsList getAnimalsByName(String name);

  void addAnimal(AnimalForSale animal);

  AnimalsForSaleList getAnimalsByType(String type);

  AnimalsForSaleList getAnimalsBySpecies(String species);

  OwnedAnimal getAnimalByIndex(int index);

  void addAnimal(OwnedAnimal ownedAnimal);

  OwnedAnimal removeAnimal(OwnedAnimal ownedAnimal);

  int getAmountOfAnimals();

  /*
  void putInCare();

  AnimalInfo getAnimalInfo();

  void addComment(String comment);

  void removeFromCare();

  String getType();

   */

  Customer getCustomerByIndex(int index);

  int getNumberOfCustomers();

  // Purchase ting

  void addExistingPurchase(Purchase purchase);

  void addNewPurchase(Customer customer, AnimalForSale animal,
      String nameForPurchasedAnimal);

  Purchase getPurchase(int index);

  int getNumberOfPurchases();

  Purchase getPurchaseByCustomer(Customer customer);

}


package model;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public interface PetShopModel extends Serializable {
  void removeOldCustomerData();

  void saveAnimalsForSaleList();

  void saveState();

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
      String email) throws IOException;

  void addCustomer(Name name, int phoneNumber, Email email) throws IOException;

  void removeCustomer(Customer customer);

  AnimalForSale removeAnimal(AnimalForSale animal);

  OwnedAnimalsList getAnimalsByCustomer(Customer customer);

  //Administrer dyr

  OwnedAnimalsList getAnimalsByName(String name);

  void addAnimalForSale(AnimalForSale animal);

  void addNewAnimalForSale(String animalType, double price,
      char gender, int age, String species, boolean extraInfo,
      boolean extraInfo2);

  AnimalsForSaleList getAnimalsByType(String type);

  AnimalsForSaleList getAnimalsBySpecies(String species);

  AnimalsForSaleList getAllAnimalsForSale();

  AnimalForSale getAnimalForSaleByIndex(int index);

  OwnedAnimal getAnimalByIndex(int index);

  void addAnimal(OwnedAnimal ownedAnimal);

  OwnedAnimal removeAnimal(OwnedAnimal ownedAnimal);

  int getAmountOfAnimals();

  Customer getCustomerByIndex(int index);

  int getNumberOfCustomers();

  // Purchase ting

  void addExistingPurchase(Purchase purchase);

  void addNewPurchase(Customer customer, AnimalForSale animal,
      String nameForPurchasedAnimal);

  Purchase getPurchase(int index);

  int getNumberOfPurchases();

  Purchase getPurchaseByCustomer(Customer customer);

  void addNewAnimalForSaleWithStrings(String text, String text1, String text2, String text3, String text4, String value, String value1);
}


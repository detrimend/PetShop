package model;

import java.io.IOException;
import java.io.Serializable;

/**
 * Interface representing the Pet Shop Model.
 * It provides methods to manage customers, animals, reservations, and purchases.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public interface PetShopModel extends Serializable
{
  /**
   * Removes old customer data.
   */
  void removeOldCustomerData();

  /**
   * Saves the list of animals for sale.
   */
  void saveAnimalsForSaleList();

  /**
   * Saves the current state of the model.
   */
  void saveState();

  /**
   * Adds a reservation for animal care.
   *
   * @param dateInterval       the date interval for the reservation
   * @param customer           the customer making the reservation
   * @param animalsToPutInCare the list of animals to put in care
   * @return true if the reservation was added successfully, false otherwise
   */
  boolean addReservation(DateInterval dateInterval, Customer customer,
      OwnedAnimalsList animalsToPutInCare);

  /**
   * Registers the handover of an animal.
   *
   * @param reservation the reservation for the handover
   */
  void registerAnimalHandover(Reservation reservation);

  /**
   * Removes a reservation by index.
   *
   * @param index the index of the reservation to remove
   */
  void removeReservation(int index);

  /**
   * Gets a customer by phone number.
   *
   * @param phoneNumber the phone number of the customer
   * @return the customer with the specified phone number
   */
  Customer getCustomer(int phoneNumber);

  /**
   * Gets the number of reservations.
   *
   * @return the number of reservations
   */
  int getNumberOfReservations();

  /**
   * Gets a reservation by phone number.
   *
   * @param phoneNumber the phone number associated with the reservation
   * @return the reservation with the specified phone number
   */
  Reservation getReservationByPhoneNumber(int phoneNumber);

  /**
   * Gets a reservation by name.
   *
   * @param name the name associated with the reservation
   * @return the reservation with the specified name
   */
  Reservation getReservationByName(String name);

  /**
   * Cancels a reservation.
   *
   * @param reservation the reservation to cancel
   * @return the canceled reservation
   */
  Reservation cancelReservation(Reservation reservation);

  /**
   * Ends a reservation.
   *
   * @param reservation the reservation to end
   * @return the ended reservation
   */
  Reservation endReservation(Reservation reservation);

  /**
   * Gets a customer by an owned animal.
   *
   * @param animal the owned animal
   * @return the customer who owns the specified animal
   */
  Customer getCustomerByAnimal(OwnedAnimal animal);

  /**
   * Adds an existing reservation.
   *
   * @param reservation the reservation to add
   */
  void addExistingReservation(Reservation reservation);

  /**
   * Gets the list of animals in care.
   *
   * @return the list of animals in care
   */
  OwnedAnimalsList getAnimalsInCare();

  /**
   * Adds a new customer.
   *
   * @param firstName   the first name of the customer
   * @param lastName    the last name of the customer
   * @param phoneNumber the phone number of the customer
   * @param email       the email of the customer
   * @throws IOException if an I/O error occurs
   */
  void addCustomer(String firstName, String lastName, String phoneNumber,
      String email) throws IOException;

  /**
   * Adds a new customer.
   *
   * @param name        the name of the customer
   * @param phoneNumber the phone number of the customer
   * @param email       the email of the customer
   * @throws IOException if an I/O error occurs
   */
  void addCustomer(Name name, int phoneNumber, Email email) throws IOException;

  /**
   * Removes a customer.
   *
   * @param customer the customer to remove
   */
  void removeCustomer(Customer customer);

  /**
   * Removes an animal for sale.
   *
   * @param animal the animal to remove
   * @return the removed animal
   */
  AnimalForSale removeAnimal(AnimalForSale animal);

  /**
   * Gets the list of animals owned by a customer.
   *
   * @param customer the customer
   * @return the list of animals owned by the customer
   */
  OwnedAnimalsList getAnimalsByCustomer(Customer customer);

  /**
   * Gets the list of animals by name.
   *
   * @param name the name of the animals
   * @return the list of animals with the specified name
   */
  OwnedAnimalsList getAnimalsByName(String name);

  /**
   * Adds an animal for sale.
   *
   * @param animal the animal to add
   */
  void addAnimalForSale(AnimalForSale animal);

  /**
   * Adds a new animal for sale.
   *
   * @param animalType the type of the animal
   * @param price      the price of the animal
   * @param gender     the gender of the animal
   * @param age        the age of the animal
   * @param species    the species of the animal
   * @param extraInfo  additional information about the animal
   * @param extraInfo2 additional information about the animal
   */
  void addNewAnimalForSale(String animalType, double price, char gender,
      int age, String species, boolean extraInfo, boolean extraInfo2);

  /**
   * Gets the list of animals for sale by type.
   *
   * @param type the type of the animals
   * @return the list of animals with the specified type
   */
  AnimalsForSaleList getAnimalsByType(String type);

  /**
   * Gets the list of animals for sale by species.
   *
   * @param species the species of the animals
   * @return the list of animals with the specified species
   */
  AnimalsForSaleList getAnimalsBySpecies(String species);

  /**
   * Gets the list of all animals for sale.
   *
   * @return the list of all animals for sale
   */
  AnimalsForSaleList getAllAnimalsForSale();

  /**
   * Gets an animal for sale by index.
   *
   * @param index the index of the animal
   * @return the animal with the specified index
   */
  AnimalForSale getAnimalForSaleByIndex(int index);

  /**
   * Gets an owned animal by index.
   *
   * @param index the index of the animal
   * @return the owned animal with the specified index
   */
  OwnedAnimal getAnimalByIndex(int index);

  /**
   * Adds an owned animal.
   *
   * @param ownedAnimal the owned animal to add
   */
  void addAnimal(OwnedAnimal ownedAnimal);

  /**
   * Removes an owned animal.
   *
   * @param ownedAnimal the owned animal to remove
   * @return the removed owned animal
   */
  OwnedAnimal removeAnimal(OwnedAnimal ownedAnimal);

  /**
   * Gets the amount of animals.
   *
   * @return the amount of animals
   */
  int getAmountOfAnimals();

  /**
   * Gets a customer by index.
   *
   * @param index the index of the customer
   * @return the customer with the specified index
   */
  Customer getCustomerByIndex(int index);

  /**
   * Gets the number of customers.
   *
   * @return the number of customers
   */
  int getNumberOfCustomers();

  /**
   * Adds an existing purchase.
   *
   * @param purchase the purchase to add
   */
  void addExistingPurchase(Purchase purchase);

  /**
   * Adds a new purchase.
   *
   * @param customer               the customer making the purchase
   * @param animal                 the animal being purchased
   * @param nameForPurchasedAnimal the name for the purchased animal
   */
  void addNewPurchase(Customer customer, AnimalForSale animal,
      String nameForPurchasedAnimal);

  /**
   * Gets a purchase by index.
   *
   * @param index the index of the purchase
   * @return the purchase with the specified index
   */
  Purchase getPurchase(int index);

  /**
   * Gets the number of purchases.
   *
   * @return the number of purchases
   */
  int getNumberOfPurchases();

  /**
   * Gets a purchase by customer.
   *
   * @param customer the customer who made the purchase
   * @return the purchase made by the specified customer
   */
  Purchase getPurchaseByCustomer(Customer customer);

  /**
   * Adds a new animal for sale with string parameters.
   *
   * @param text   the first parameter
   * @param text1  the second parameter
   * @param text2  the third parameter
   * @param text3  the fourth parameter
   * @param text4  the fifth parameter
   * @param value  the sixth parameter
   * @param value1 the seventh parameter
   */
  void addNewAnimalForSaleWithStrings(String text, String text1, String text2,
      String text3, String text4, String value, String value1);

  /**
   * Gets the number of animals for sale.
   *
   * @return the number of animals for sale
   */
  int getNumberOfAnimalsForSale();
}
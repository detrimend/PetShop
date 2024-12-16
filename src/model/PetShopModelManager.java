package model;

import parser.ParserException;
import persistence.AnimalsForSaleListPersistenceManager;
import persistence.PetShopPersistenceManager;

import java.io.*;

/**
 * Class representing the Pet Shop Model Manager.
 * It implements the PetShopModel interface and provides methods to manage customers, animals, reservations, and purchases.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class PetShopModelManager implements PetShopModel, Serializable
{
  private static final long serialVersionUID = 1L;

  private CustomerList customerList;
  private AnimalsForSaleList animalsForSaleList;
  private OwnedAnimalsList ownedAnimalsList;
  private ReservationList reservationList;
  private PurchaseList purchaseList;
  private PurgeGDPR purgeGDPR;
  private transient AnimalsForSaleListPersistenceManager animalsForSaleListToXML;
  private transient PetShopPersistenceManager modelManagerToBinary;

  /**
   * Constructs a new PetShopModelManager.
   * Loads the state from a file if it exists, otherwise initializes new lists.
   */
  public PetShopModelManager()
  {
    this.modelManagerToBinary = new PetShopPersistenceManager();
    this.animalsForSaleListToXML = new AnimalsForSaleListPersistenceManager();
    PetShopModelManager loaded = modelManagerToBinary.loadState();
    if (loaded != null)
    {
      this.customerList = loaded.customerList;
      this.animalsForSaleList = loaded.animalsForSaleList;
      this.ownedAnimalsList = loaded.ownedAnimalsList;
      this.reservationList = loaded.reservationList;
      this.purchaseList = loaded.purchaseList;
      this.purgeGDPR = loaded.purgeGDPR;

      System.out.println("PetShopModelManager loaded from file");
    }
    else
    {
      this.customerList = new CustomerList();
      this.animalsForSaleList = new AnimalsForSaleList();
      this.ownedAnimalsList = new OwnedAnimalsList();
      this.reservationList = new ReservationList();
      this.purchaseList = new PurchaseList();
      this.purgeGDPR = new PurgeGDPR(this.reservationList, this.purchaseList,
          this.customerList);
      System.out.println("PetShopModelManager file created");
    }
  }

  /**
   * Saves the current state of the model.
   */
  @Override public void saveState()
  {
    modelManagerToBinary.saveState(this);
  }

  /**
   * Saves the list of animals for sale.
   */
  @Override public void saveAnimalsForSaleList()
  {
    try
    {
      animalsForSaleListToXML.saveAnimalsForSaleList(animalsForSaleList,
          "AnimalsForSaleList.xml");
    }
    catch (IOException | ParserException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Removes old customer data.
   */
  @Override public void removeOldCustomerData()
  {
    purgeGDPR.removeOldCustomerData();
    saveState();
  }

  /**
   * Adds a reservation for animal care.
   *
   * @param dateInterval       the date interval for the reservation
   * @param customer           the customer making the reservation
   * @param animalsToPutInCare the list of animals to put in care
   * @return true if the reservation was added successfully, false otherwise
   */
  @Override public boolean addReservation(DateInterval dateInterval,
      Customer customer, OwnedAnimalsList animalsToPutInCare)
  {
    saveState();
    return reservationList.addReservation(dateInterval, customer,
        animalsToPutInCare);
  }

  /**
   * Registers the handover of an animal.
   *
   * @param reservation the reservation for the handover
   */
  @Override public void registerAnimalHandover(Reservation reservation)
  {
    for (int i = 0; i < reservationList.getNumberOfReservations(); i++)
    {
      if (reservationList.getReservation(i).equals(reservation))
      {
        reservationList.registerAnimalHandover(reservation);
      }
    }
    saveState();
  }

  /**
   * Removes a reservation by index.
   *
   * @param index the index of the reservation to remove
   */
  @Override public void removeReservation(int index)
  {
    reservationList.removeReservation(index);
    saveState();
  }

  /**
   * Gets a customer by phone number.
   *
   * @param phoneNumber the phone number of the customer
   * @return the customer with the specified phone number
   */
  @Override public Customer getCustomer(int phoneNumber)
  {
    return customerList.getCustomer(phoneNumber);
  }

  /**
   * Gets the number of reservations.
   *
   * @return the number of reservations
   */
  @Override public int getNumberOfReservations()
  {
    return reservationList.getNumberOfReservations();
  }

  /**
   * Gets a reservation by phone number.
   *
   * @param phoneNumber the phone number associated with the reservation
   * @return the reservation with the specified phone number
   */
  @Override public Reservation getReservationByPhoneNumber(int phoneNumber)
  {
    return reservationList.getReservationByNumber(phoneNumber);
  }

  /**
   * Gets a reservation by name.
   *
   * @param name the name associated with the reservation
   * @return the reservation with the specified name
   */
  @Override public Reservation getReservationByName(String name)
  {
    return reservationList.getReservationByName(name);
  }

  /**
   * Cancels a reservation.
   *
   * @param reservation the reservation to cancel
   * @return the canceled reservation
   */
  @Override public Reservation cancelReservation(Reservation reservation)
  {
    reservationList.cancelReservation(reservation);
    saveState();
    return reservation;
  }

  /**
   * Ends a reservation.
   *
   * @param reservation the reservation to end
   * @return the ended reservation
   */
  @Override public Reservation endReservation(Reservation reservation)
  {
    reservationList.endReservation(reservation);
    saveState();
    return reservation;
  }

  /**
   * Gets a customer by an owned animal.
   *
   * @param animal the owned animal
   * @return the customer who owns the specified animal
   */
  @Override public Customer getCustomerByAnimal(OwnedAnimal animal)
  {
    return customerList.getCustomerByAnimal(animal);
  }

  /**
   * Adds an existing reservation.
   *
   * @param reservation the reservation to add
   */
  @Override public void addExistingReservation(Reservation reservation)
  {
    reservationList.addExistingReservation(reservation);
    saveState();
  }

  /**
   * Gets the list of animals in care.
   *
   * @return the list of animals in care
   */
  @Override public OwnedAnimalsList getAnimalsInCare()
  {
    OwnedAnimalsList animalsInCare = new OwnedAnimalsList();
    for (int i = 0; i < ownedAnimalsList.getAmountOfAnimals(); i++)
    {
      if (ownedAnimalsList.getAnimalByIndex(i).isInCare())
      {
        animalsInCare.addAnimal(ownedAnimalsList.getAnimalByIndex(i));
      }
    }
    return animalsInCare;
  }

  /**
   * Adds a new customer.
   *
   * @param firstName   the first name of the customer
   * @param lastName    the last name of the customer
   * @param email       the email of the customer
   * @param phoneNumber the phone number of the customer
   */
  @Override public void addCustomer(String firstName, String lastName,
      String email, String phoneNumber)
  {
    System.out.println(email);
    String[] split = email.split("@");
    String user = split[0];
    split = split[1].split("\\.");
    String domain = split[0];
    String host = split[1];
    customerList.addCustomer(firstName, lastName, new Email(user, domain, host),
        Integer.parseInt(phoneNumber));
    saveState();
  }

  /**
   * Adds a new customer.
   *
   * @param name        the name of the customer
   * @param phoneNumber the phone number of the customer
   * @param email       the email of the customer
   */
  @Override public void addCustomer(Name name, int phoneNumber, Email email)
  {
    customerList.addCustomer(name, email, phoneNumber);
    saveState();
  }

  /**
   * Removes a customer.
   *
   * @param customer the customer to remove
   */
  @Override public void removeCustomer(Customer customer)
  {
    customerList.removeCustomer(customer);
    saveState();
  }

  /**
   * Removes an animal for sale.
   *
   * @param animal the animal to remove
   * @return the removed animal
   */
  @Override public AnimalForSale removeAnimal(AnimalForSale animal)
  {
    animalsForSaleList.removeAnimal(animal);
    saveAnimalsForSaleList();
    saveState();
    return animal;
  }

  /**
   * Gets the list of animals owned by a customer.
   *
   * @param customer the customer
   * @return the list of animals owned by the customer
   */
  @Override public OwnedAnimalsList getAnimalsByCustomer(Customer customer)
  {
    return ownedAnimalsList.getAnimalsByCustomer(customer);
  }

  /**
   * Gets the list of animals by name.
   *
   * @param name the name of the animals
   * @return the list of animals with the specified name
   */
  @Override public OwnedAnimalsList getAnimalsByName(String name)
  {
    return ownedAnimalsList.getAnimalsByName(name);
  }

  /**
   * Adds an animal for sale.
   *
   * @param animal the animal to add
   */
  @Override public void addAnimalForSale(AnimalForSale animal)
  {
    animalsForSaleList.addAnimal(animal);
    saveAnimalsForSaleList();
    saveState();
  }

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
  @Override public void addNewAnimalForSale(String animalType, double price,
      char gender, int age, String species, boolean extraInfo,
      boolean extraInfo2)
  {
    animalsForSaleList.addAnimal(
        new AnimalForSale(animalType, price, gender, age, species, extraInfo,
            extraInfo2));
    saveAnimalsForSaleList();
    saveState();
  }

  /**
   * Gets the list of animals for sale by type.
   *
   * @param type the type of the animals
   * @return the list of animals with the specified type
   */
  @Override public AnimalsForSaleList getAnimalsByType(String type)
  {
    return animalsForSaleList.getAnimalsByType(type);
  }

  /**
   * Gets the list of animals for sale by species.
   *
   * @param species the species of the animals
   * @return the list of animals with the specified species
   */
  @Override public AnimalsForSaleList getAnimalsBySpecies(String species)
  {
    return animalsForSaleList.getAnimalsBySpecies(species);
  }

  /**
   * Gets the list of all animals for sale.
   *
   * @return the list of all animals for sale
   */
  @Override public AnimalsForSaleList getAllAnimalsForSale()
  {
    return animalsForSaleList;
  }

  /**
   * Gets an animal for sale by index.
   *
   * @param index the index of the animal
   * @return the animal with the specified index
   */
  @Override public AnimalForSale getAnimalForSaleByIndex(int index)
  {
    return animalsForSaleList.getAnimalForSaleByIndex(index);
  }

  /**
   * Gets an owned animal by index.
   *
   * @param index the index of the animal
   * @return the owned animal with the specified index
   */
  @Override public OwnedAnimal getAnimalByIndex(int index)
  {
    return ownedAnimalsList.getAnimalByIndex(index);
  }

  /**
   * Adds an owned animal.
   *
   * @param ownedAnimal the owned animal to add
   */
  @Override public void addAnimal(OwnedAnimal ownedAnimal)
  {
    ownedAnimalsList.addAnimal(ownedAnimal);
    saveState();
  }

  /**
   * Removes an owned animal.
   *
   * @param ownedAnimal the owned animal to remove
   * @return the removed owned animal
   */
  @Override public OwnedAnimal removeAnimal(OwnedAnimal ownedAnimal)
  {
    ownedAnimalsList.removeAnimal(ownedAnimal);
    saveState();
    return ownedAnimal;
  }

  /**
   * Gets the amount of animals.
   *
   * @return the amount of animals
   */
  @Override public int getAmountOfAnimals()
  {
    return ownedAnimalsList.getAmountOfAnimals();
  }

  /**
   * Gets a customer by index.
   *
   * @param index the index of the customer
   * @return the customer with the specified index
   */
  @Override public Customer getCustomerByIndex(int index)
  {
    return customerList.getCustomerByIndex(index);
  }

  /**
   * Gets the number of customers.
   *
   * @return the number of customers
   */
  @Override public int getNumberOfCustomers()
  {
    return customerList.getNumberOfCustomers();
  }

  /**
   * Adds an existing purchase.
   *
   * @param purchase the purchase to add
   */
  @Override public void addExistingPurchase(Purchase purchase)
  {
    purchaseList.addExistingPurchase(purchase);
    saveState();
  }

  /**
   * Adds a new purchase.
   *
   * @param customer               the customer making the purchase
   * @param animal                 the animal being purchased
   * @param nameForPurchasedAnimal the name for the purchased animal
   */
  @Override public void addNewPurchase(Customer customer, AnimalForSale animal,
      String nameForPurchasedAnimal)
  {
    purchaseList.addNewPurchase(customer, animal, nameForPurchasedAnimal);
    animalsForSaleList.removeAnimal(animal);
    for (int i = 0; i < customer.getOwnedAnimals().getAmountOfAnimals(); i++)
    {
      if (customer.getOwnedAnimals().getAnimalByIndex(i).getName()
          .equals(nameForPurchasedAnimal))
      {
        ownedAnimalsList.addAnimal(
            customer.getOwnedAnimals().getAnimalByIndex(i));
      }
    }
    saveState();
    saveAnimalsForSaleList();
  }

  /**
   * Gets a purchase by index.
   *
   * @param index the index of the purchase
   * @return the purchase with the specified index
   */
  @Override public Purchase getPurchase(int index)
  {
    return purchaseList.getPurchase(index);
  }

  /**
   * Gets the number of purchases.
   *
   * @return the number of purchases
   */
  @Override public int getNumberOfPurchases()
  {
    return purchaseList.getNumberOfPurchases();
  }

  /**
   * Gets a purchase by customer.
   *
   * @param customer the customer who made the purchase
   * @return the purchase made by the specified customer
   */
  @Override public Purchase getPurchaseByCustomer(Customer customer)
  {
    return purchaseList.getPurchaseByCustomer(customer);
  }

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
  @Override public void addNewAnimalForSaleWithStrings(String text,
      String text1, String text2, String text3, String text4, String value,
      String value1)
  {
    String animalType = text;
    double price = Double.parseDouble(text1);
    char gender = text2.charAt(0);
    int age = Integer.parseInt(text3);
    String species = text4;
    boolean extraInfo = Boolean.parseBoolean(value);
    boolean extraInfo2 = Boolean.parseBoolean(value1);
    animalsForSaleList.addAnimal(
        new AnimalForSale(animalType, price, gender, age, species, extraInfo,
            extraInfo2));
    saveAnimalsForSaleList();
    saveState();
  }

  /**
   * Gets the number of animals for sale.
   *
   * @return the number of animals for sale
   */
  @Override public int getNumberOfAnimalsForSale()
  {
    return animalsForSaleList.getNumberOfAnimalsForSale();
  }

}
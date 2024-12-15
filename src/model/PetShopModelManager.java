package model;

import parser.ParserException;
import persistence.AnimalsForSaleListPersistenceManager;
import persistence.PetShopPersistenceManager;

import java.io.*;

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
    // til debug: ownedAnimalsList.addAnimal(new OwnedAnimal("mammal", "Rasmus", customerList.getCustomerByIndex(0), 'M', 2, "Funnyguy", true, false));
  }

  @Override public void saveState()
  {
    modelManagerToBinary.saveState(this);
  }

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

  @Override public void removeOldCustomerData()
  {
    purgeGDPR.removeOldCustomerData();
  }

  //Statement til at oprette animalsToPutInCare?
  @Override public boolean addReservation(DateInterval dateInterval,
      Customer customer, OwnedAnimalsList animalsToPutInCare)
  {
    return reservationList.addReservation(dateInterval, customer,
        animalsToPutInCare);
  }

  @Override public void registerAnimalHandover(Reservation reservation)
  {
    for (int i = 0; i < reservationList.getNumberOfReservations(); i++)
    {
      if (reservationList.getReservation(i).equals(reservation))
      {
        reservationList.registerAnimalHandover(reservation);
      }
    }
  }

  @Override public void removeReservation(int index)
  {
    reservationList.removeReservation(index);
  }

  @Override public Customer getCustomer(int phoneNumber)
  {
    return customerList.getCustomer(phoneNumber);
  }

  @Override public int getNumberOfReservations()
  {
    return reservationList.getNumberOfReservations();
  }

  @Override public Reservation getReservationByPhoneNumber(int phoneNumber)
  {
    return reservationList.getReservationByNumber(phoneNumber);
  }

  @Override public Reservation getReservationByName(String name)
  {
    return reservationList.getReservationByName(name);
  }

  @Override public Reservation cancelReservation(Reservation reservation)
  {
    reservationList.cancelReservation(reservation);
    return reservation;
  }

  @Override public Reservation endReservation(Reservation reservation)
  {
    reservationList.endReservation(reservation);
    return reservation;
  }

  @Override public Customer getCustomerByAnimal(OwnedAnimal animal)
  {
    return customerList.getCustomerByAnimal(animal);
  }

  @Override public void addExistingReservation(Reservation reservation)
  {
    reservationList.addExistingReservation(reservation);
  }

  @Override public void addCustomer(String firstName, String lastName,
      String email, String phoneNumber) throws IOException
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

  @Override public void addCustomer(Name name, int phoneNumber, Email email)
      throws IOException
  {
    customerList.addCustomer(name, email, phoneNumber);
  }

  @Override public void removeCustomer(Customer customer)
  {
    customerList.removeCustomer(customer);
  }

  @Override public AnimalForSale removeAnimal(AnimalForSale animal)
  {
    animalsForSaleList.removeAnimal(animal);
    saveAnimalsForSaleList();
    return animal;
  }

  @Override public OwnedAnimalsList getAnimalsByCustomer(Customer customer)
  {
    return ownedAnimalsList.getAnimalsByCustomer(customer);
  }

  // Name her er navnet på dyret
  @Override public OwnedAnimalsList getAnimalsByName(String name)
  {
    return ownedAnimalsList.getAnimalsByName(name);
  }

  @Override public void addAnimalForSale(AnimalForSale animal)
  {
    animalsForSaleList.addAnimal(animal);
    saveAnimalsForSaleList();
  }

  @Override public void addNewAnimalForSale(String animalType, double price,
      char gender, int age, String species, boolean extraInfo,
      boolean extraInfo2)
  {
    animalsForSaleList.addAnimal(
        new AnimalForSale(animalType, price, gender, age, species, extraInfo,
            extraInfo2));
    saveAnimalsForSaleList();
  }

  @Override public AnimalsForSaleList getAnimalsByType(String type)
  {
    return animalsForSaleList.getAnimalsByType(type);
  }

  @Override public AnimalsForSaleList getAnimalsBySpecies(String species)
  {
    return animalsForSaleList.getAnimalsBySpecies(species);
  }

  @Override public AnimalForSale getAnimalForSaleByIndex(int index)
  {
    return animalsForSaleList.getAnimalForSaleByIndex(index);
  }

  @Override public AnimalsForSaleList getAllAnimalsForSale()
  {
    return animalsForSaleList;
  }

  @Override public OwnedAnimal getAnimalByIndex(int index)
  {
    return ownedAnimalsList.getAnimalByIndex(index);
  }

  @Override public void addAnimal(OwnedAnimal ownedAnimal)
  {
    ownedAnimalsList.addAnimal(ownedAnimal);
  }

  @Override public OwnedAnimal removeAnimal(OwnedAnimal ownedAnimal)
  {
    ownedAnimalsList.removeAnimal(ownedAnimal);
    return ownedAnimal;
  }

  @Override public int getAmountOfAnimals()
  {
    return ownedAnimalsList.getAmountOfAnimals();
  }

  @Override public Customer getCustomerByIndex(int index)
  {
    return customerList.getCustomerByIndex(index);
  }

  @Override public int getNumberOfCustomers()
  {
    return customerList.getNumberOfCustomers();
  }

  //Purchase ting

  @Override public void addExistingPurchase(Purchase purchase)
  {
    purchaseList.addExistingPurchase(purchase);
  }

  @Override public void addNewPurchase(Customer customer, AnimalForSale animal,
      String nameForPurchasedAnimal)
  {
    purchaseList.addNewPurchase(customer, animal, nameForPurchasedAnimal);
    animalsForSaleList.removeAnimal(animal);
    for(int i = 0; i < customer.getOwnedAnimals().getAmountOfAnimals(); i++)
    {
      if(customer.getOwnedAnimals().getAnimalByIndex(i).getName().equals(nameForPurchasedAnimal))
      {
        ownedAnimalsList.addAnimal(customer.getOwnedAnimals().getAnimalByIndex(i));
      }
    }
    saveState();
    saveAnimalsForSaleList();
  }

  @Override public Purchase getPurchase(int index)
  {
    return purchaseList.getPurchase(index);
  }

  @Override public int getNumberOfPurchases()
  {
    return purchaseList.getNumberOfPurchases();
  }

  @Override public Purchase getPurchaseByCustomer(Customer customer)
  {
    return purchaseList.getPurchaseByCustomer(customer);
  }

  @Override public void addNewAnimalForSaleWithStrings(String text, String text1, String text2,
      String text3, String text4, String value, String value1)
  {
    String animalType = text;
    double price = Double.parseDouble(text1);
    char gender = text2.charAt(0);
    int age = Integer.parseInt(text3);
    String species = text4;
    boolean extraInfo = Boolean.parseBoolean(value);
    boolean extraInfo2 = Boolean.parseBoolean(value1);
    animalsForSaleList.addAnimal(new AnimalForSale(animalType, price, gender, age, species, extraInfo, extraInfo2));
    saveAnimalsForSaleList();
    saveState();
  }

  @Override public int getNumberOfAnimalsForSale()
  {
    return animalsForSaleList.getNumberOfAnimalsForSale();
  }



}
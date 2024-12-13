package model;

import parser.ParserException;
import persistence.FilePersistenceManager;
import persistence.PetShopPersistenceManager;

import java.io.*;
import java.time.LocalDate;

public class PetShopModelManager implements PetShopModel, Serializable
{
  private static final long serialVersionUID = 1L;

  private CustomerList customerList;
  private AnimalsForSaleList animalsForSaleList;
  private OwnedAnimalsList ownedAnimalsList;
  private ReservationList reservationList;
  private PurchaseList purchaseList;
  private PurgeGDPR purgeGDPR;
  private FilePersistenceManager filePersistenceManager;

  private transient PetShopPersistenceManager persistenceManager;

  public PetShopModelManager()
  {
    this.persistenceManager = new PetShopPersistenceManager();
    PetShopModelManager loaded = persistenceManager.loadState();
    if (loaded != null) {
      this.customerList = loaded.customerList;
      this.animalsForSaleList = loaded.animalsForSaleList;
      this.ownedAnimalsList = loaded.ownedAnimalsList;
      this.reservationList = loaded.reservationList;
      this.purchaseList = loaded.purchaseList;
      this.purgeGDPR = loaded.purgeGDPR;
      this.filePersistenceManager = loaded.filePersistenceManager;
    } else {
      this.customerList = new CustomerList();
      this.animalsForSaleList = new AnimalsForSaleList();
      this.ownedAnimalsList = new OwnedAnimalsList();
      this.reservationList = new ReservationList();
      this.purchaseList = new PurchaseList();
      this.purgeGDPR = new PurgeGDPR(this.reservationList, this.purchaseList,
          this.customerList);
      this.filePersistenceManager = new FilePersistenceManager();
    }
  }

  @Override public void saveState() {
    persistenceManager.saveState(this);
  }


  @Override public void saveAnimalsForSaleList()
  {
    try
    {
      filePersistenceManager.saveAnimalsForSaleList(animalsForSaleList,
          "AnimalsForSaleList.xml");
    }
    catch (IOException | ParserException e)
    {
      e.printStackTrace();
    }
  }

  /*
  @Override
  public void saveCustomerList() throws IOException {

    filePersistenceManager.saveCustomerList(customerList, "CustomerList.bin");
  }

  @Override
  public void loadCustomerList() {
    filePersistenceManager.loadCustomerList("CustomerList.bin");
  }

  public void saveCustomerList(CustomerList customerList, String filePath) {
    try (FileOutputStream fileOutputStream = new FileOutputStream("Customerlist.bin");
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(customerList);
      System.out.println("Customer list saved in binary format to " + filePath);
    }
    catch (IOException e) {
      e.printStackTrace();
      System.err.println("Failed to save the customer list.");
    }
  }

  public static void loadCustomerList(String filePath) {
    try (FileInputStream fileInputStream = new FileInputStream("Customerlist.bin");
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {


      CustomerList customerList = (CustomerList) objectInputStream.readObject();


      System.out.println("Loaded customer list:");
      System.out.println(customerList);

    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Failed to load customer list: " + e.getMessage());
      e.printStackTrace();
    }
  }



  public void saveCustomerList()
  {
    try
    {
      filePersistenceManager.saveCustomerList(customerList,
          "AnimalsForSaleList.xml");
    }
    catch (IOException | ParserException e)
    {
      e.printStackTrace();
    }
  }*/

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
      String email, String phoneNumber) throws IOException {
    System.out.println(email);
    String[] split = email.split("@");
    String user = split[0];
    split = split[1].split("\\.");
    String domain = split[0];
    String host = split[1];
    customerList.addCustomer(firstName, lastName, new Email(user, domain, host),
        Integer.parseInt(phoneNumber));
    //loadCustomerList("Customerlist.bin");
    //saveCustomerList();
    saveState();
  }

  @Override public void addCustomer(Name name, int phoneNumber, Email email) throws IOException {
    customerList.addCustomer(name, email, phoneNumber);
    //loadCustomerList("Customerlist.bin");
    //saveCustomerList();
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

  @Override public void addAnimal(AnimalForSale animal)
  {
    animalsForSaleList.addAnimal(animal);
    saveAnimalsForSaleList();
    //loadCustomerList("Customerlist.bin");
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

}
package model;

import parser.ParserException;
import persistence.FilePersistenceManager;

import java.io.IOException;
import java.time.LocalDate;

public class PetShopModelManager implements PetShopModel
{
  private CustomerList customerList;
  private AnimalsForSaleList animalsForSaleList;
  private OwnedAnimalsList ownedAnimalsList;
  private ReservationList reservationList;
  private PurchaseList purchaseList;
  private PurgeGDPR purgeGDPR;
  private FilePersistenceManager filePersistenceManager;


  public PetShopModelManager()
  {
    this.customerList = new CustomerList();
    this.animalsForSaleList = new AnimalsForSaleList();
    this.ownedAnimalsList = new OwnedAnimalsList();
    this.reservationList = new ReservationList();
    this.purchaseList = new PurchaseList();
    this.purgeGDPR = new PurgeGDPR(this.reservationList, this.purchaseList,
        this.customerList);
    this.filePersistenceManager = new FilePersistenceManager();
    animalsForSaleList.addAnimal(new AnimalForSale("mammal",25.5,'m',2,"bunny",false,false));
  }

  @Override
  public void saveAnimalsForSaleList() {
    try {
      filePersistenceManager.saveAnimalsForSaleList(animalsForSaleList, "AnimalsForSaleList.xml");
    } catch (IOException | ParserException e) {
      e.printStackTrace();
    }
  }

  public void saveCustomerList() {
    try {
      filePersistenceManager.saveCustomerList(customerList, "AnimalsForSaleList.xml");
    } catch (IOException | ParserException e) {
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
    return reservationList.addReservation(dateInterval, customer, animalsToPutInCare);
  }

  @Override public void registerAnimalHandover(Reservation reservation)
  {
    for(int i = 0; i < reservationList.getNumberOfReservations(); i++)
    {
      if(reservationList.getReservation(i).equals(reservation))
      {
        reservationList.registerAnimalHandover(reservation);
      }
    }
  }

  @Override public void removeReservation(int index)
  {
    for(int i = 0; i < reservationList.getNumberOfReservations(); i++)
    {
      if(reservationList.getReservation(i).equals(index))
      {
        reservationList.removeReservation(index);
      }
    }
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

  @Override public void addCustomer(String firstName, String lastName,
      String email,String phoneNumber)

  {
    System.out.println(email);
    String[] split = email.split("@");
    String user = split[0];
    split = split[1].split("\\.");
    String domain = split[0];
    String host = split[1];
    customerList.addCustomer(firstName, lastName,new Email(user,domain,host),Integer.parseInt(phoneNumber));
    saveCustomerList();
  }

  @Override public void addCustomer(Name name, int phoneNumber, Email email)
  {
   customerList.addCustomer(name,email,phoneNumber);
  }

  @Override public void removeCustomer(Customer customer)
  {
    customerList.removeCustomer(customer);
  }

  /*
  Ret sikker på at de fire nedenstående metoder er overflødige
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
   */

  @Override public OwnedAnimal assignAnimalToCustomer(AnimalForSale animal,
      Customer customer, String name)
  {
    // Mangler implementation
    saveAnimalsForSaleList();
    return assignAnimalToCustomer(animal, customer, name);
  }

  @Override public AnimalForSale removeAnimal(AnimalForSale animal)
  {
    animalsForSaleList.removeAnimal(animal);
    saveAnimalsForSaleList();
    return animal;
  }

  /*
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

   */

  @Override public void addAnimal(AnimalForSale animal)
  {
    animalsForSaleList.addAnimal(animal);
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

  /*
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

   */

  @Override public Customer getCustomerByIndex(int index)
  {
    return customerList.getCustomerByIndex(index);
  }

  @Override public int getNumberOfCustomers()
  {
    return customerList.getNumberOfCustomers();
  }

}
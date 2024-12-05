package model;

import java.time.LocalDate;

public class Purchase
{
  private LocalDate date;
  private Customer customer;
  private AnimalForSale animal;
  private AnimalsForSaleList animalsForSaleList;

  public Purchase(Customer customer, LocalDate date, AnimalForSale animal, AnimalsForSaleList animalsForSaleList)
  {
    this.date = date;
    this.customer = customer;
    this.animal = animal;
    this.animalsForSaleList = animalsForSaleList;
  }

  public OwnedAnimal assignAnimalToCustomer(AnimalForSale animal, Customer customer, String name)
  {
    AnimalInfo type = animal.getAnimalInfo();
    OwnedAnimal ownedAnimal = new OwnedAnimal(name, customer, type);
    customer.addOwnedAnimal(ownedAnimal);
    animalsForSaleList.removeAnimal(animal);
    return ownedAnimal;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public LocalDate getDate()
  {
    return date;
  }
}

package model;

import java.time.LocalDate;

public class Purchase
{
  private LocalDate date;
  private Customer customer;
  private AnimalForSale animal;

  public Purchase(Customer customer, LocalDate date, AnimalForSale animal)
  {
    this.date = date;
    this.customer = customer;
    this.animal = animal;
  }

  public OwnedAnimal assignAnimalToCustomer(AnimalForSale animal, Customer customer, String name)
  {
    AnimalInfo type = animal.getAnimalInfo();
    OwnedAnimal ownedAnimal = new OwnedAnimal(name, customer, type);
    customer.addOwnedAnimal(ownedAnimal);
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

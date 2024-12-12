package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class representing a purchase with specific attributes such as date, customer, animal, and animals for sale list.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Purchase
{
  private LocalDate date;
  private Customer customer;
  private AnimalForSale animal;

  /**
   * Constructs a Purchase with the specified attributes.
   *
   * @param customer the customer making the purchase
   * @param animal the animal being purchased
   * @param nameForPurchasedAnimal the name to assign to the purchased animal
   * @throws IllegalArgumentException if any of the parameters are null
   */
  public Purchase(Customer customer, AnimalForSale animal, String nameForPurchasedAnimal)
  {
    if (customer == null)
    {
      throw new IllegalArgumentException("Customer cannot be null");
    }
    if (animal == null)
    {
      throw new IllegalArgumentException("Animal cannot be null");
    }
    if (nameForPurchasedAnimal == null)
    {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.date = LocalDate.now(); //Måske ikke korrekt?
    this.customer = customer;
    this.animal = animal;
    assignAnimalToCustomer(animal, customer, nameForPurchasedAnimal);
  }

  /**
   * Assigns an animal for sale to a customer by copying it's information to an owned animal.
   *
   * @param animal the animal to be assigned
   * @param customer the customer to whom the animal is assigned
   * @param nameForPurchasedAnimal the name to assign to the purchased animal
   */
  public void assignAnimalToCustomer(AnimalForSale animal,
      Customer customer, String nameForPurchasedAnimal)
  {
    AnimalInfo type = animal.getAnimalInfo();
    OwnedAnimal ownedAnimal = new OwnedAnimal(nameForPurchasedAnimal, customer, type);
    customer.addOwnedAnimal(ownedAnimal);
  }

  /**
   * Returns the customer making the purchase.
   *
   * @return the customer making the purchase
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * Returns the date of the purchase.
   *
   * @return the date of the purchase
   */
  public LocalDate getDate()
  {
    return date;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare
   * @return true if this object is the same as the o argument; false otherwise
   */
  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    Purchase purchase = (Purchase) o;
    return Objects.equals(date, purchase.date) && Objects.equals(customer,
        purchase.customer) && Objects.equals(animal, purchase.animal);
  }

  /**
   * Returns a string representation of the purchase.
   *
   * @return a string representation of the purchase
   */
  @Override public String toString()
  {
    return "Purchase{" + "animal=" + animal + ", customer=" + customer
        + ", date=" + date + '}';
  }
}
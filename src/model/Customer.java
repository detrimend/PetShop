package model;

import java.io.Serializable;

/**
 * Class representing a customer with a phone number and a list of owned animals.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Customer extends Person implements Serializable
{
  private int phoneNumber;
  private OwnedAnimalsList animals;

  /**
   * Constructs a Customer with the specified name, email, and phone number.
   *
   * @param name        the name of the customer
   * @param email       the email of the customer
   * @param phoneNumber the phone number of the customer
   */
  public Customer(Name name, Email email, int phoneNumber)
  {
    super(name, email);
    setPhoneNumber(phoneNumber);
    this.animals = new OwnedAnimalsList();
  }

  /**
   * Constructs a Customer with the specified first name, last name, email, and phone number.
   *
   * @param firstName   the first name of the customer
   * @param lastName    the last name of the customer
   * @param email       the email of the customer
   * @param phoneNumber the phone number of the customer
   */
  public Customer(String firstName, String lastName, Email email,
      int phoneNumber)
  {
    super(firstName, lastName, email);
    setPhoneNumber(phoneNumber);
    this.animals = new OwnedAnimalsList();
  }

  /**
   * Returns the phone number of the customer.
   *
   * @return the phone number of the customer
   */
  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  /**
   * Sets the phone number of the customer.
   *
   * @param phoneNumber the new phone number of the customer
   * @throws IllegalArgumentException if the phone number is not a positive integer
   */
  public void setPhoneNumber(int phoneNumber)
  {
    if (phoneNumber < 0)
    {
      throw new IllegalArgumentException(
          "Phone number must be a positive integer");
    }
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns the list of animals owned by the customer.
   *
   * @return the list of animals owned by the customer
   */
  public OwnedAnimalsList getOwnedAnimals()
  {
    return animals;
  }

  /**
   * Adds an animal to the list of animals owned by the customer.
   *
   * @param ownedAnimal the animal to add
   */
  public void addOwnedAnimal(OwnedAnimal ownedAnimal)
  {
    animals.addAnimal(ownedAnimal);
  }

  /**
   * Returns a string representation of the customer.
   *
   * @return a string representation of the customer
   */
  @Override public String toString()
  {
    return super.toString() + "\n" + "kundens telefonnummer er: " + phoneNumber
        + "\n" + "kunden ejer følgende dyr" + getOwnedAnimals().toString();
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare
   * @return true if this object is the same as the obj argument; false otherwise
   */
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Customer customer = (Customer) obj;
    return super.equals(customer) && phoneNumber == customer.phoneNumber;
  }
}




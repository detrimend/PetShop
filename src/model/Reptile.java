package model;

/**
 * Class representing a reptile with specific attributes such as gender, age, species, and whether it is venomous.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Reptile extends AnimalInfo
{
  private boolean venomous;

  /**
   * Constructs a Reptile with the specified attributes.
   *
   * @param gender the gender of the reptile ('M' or 'F')
   * @param age the age of the reptile
   * @param species the species of the reptile
   * @param venomous whether the reptile is venomous
   */
  public Reptile(char gender, int age, String species, boolean venomous)
  {
    super(gender, age, species);
    this.venomous = venomous;
  }

  /**
   * Returns whether the reptile is venomous.
   *
   * @return true if the reptile is venomous, false otherwise
   */
  public boolean isVenomous()
  {
    return venomous;
  }

  /**
   * Returns a string representation of the reptile.
   *
   * @return a string representation of the reptile
   */
  @Override public String toString()
  {
    return "Reptile " + super.toString() + venomous;
  }

  /**
   * Returns the type of the animal.
   *
   * @return the type of the animal
   */
  @Override public String getType()
  {
    return "Reptile";
  }
}
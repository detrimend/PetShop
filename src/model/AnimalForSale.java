package model;

import java.util.Objects;

/**
 * Class representing an animal for sale with a price, sale status, and type.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalForSale
{
  private double price;
  private boolean isForSale;
  private AnimalInfo type;

  /**
   * Constructs an AnimalForSale with the specified attributes.
   *
   * @param animalType the type of the animal (e.g., mammal, fish, reptile, bird)
   * @param price the price of the animal
   * @param isForSale the sale status of the animal
   * @param gender the gender of the animal
   * @param age the age of the animal
   * @param species the species of the animal
   * @param extraInfo additional information specific to the animal type
   * @param extraInfo2 additional information specific to the animal type (used for birds)
   * @throws IllegalArgumentException if the price is negative or the animal type is unknown
   */
  public AnimalForSale(String animalType, double price,
      char gender, int age, String species, boolean extraInfo,
      boolean extraInfo2)
  {
    if (price < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
    this.isForSale = true;

    // Dynamically create AnimalInfo subclasses based on animalType
    switch (animalType.toLowerCase())
    {
      case "mammal":
        this.type = new Mammal(gender, age, species,
            extraInfo); // Mammal: extraInfo = outdoorOnly
        break;
      case "fish":
        this.type = new Fish(gender, age, species,
            extraInfo); // Fish: extraInfo = saltWater
        break;
      case "reptile":
        this.type = new Reptile(gender, age, species,
            extraInfo); // Reptile: extraInfo = venomous
        break;
      case "bird":
        this.type = new Bird(gender, age, species, extraInfo,
            extraInfo2); // Bird: extraInfo = tame, extraInfo2 = isTamable
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown animal type: " + animalType);
    }
  }

  /**
   * Returns the price of the animal.
   *
   * @return the price of the animal
   */
  public double getPrice()
  {
    return price;
  }

  /**
   * Sets the price of the animal.
   *
   * @param price the new price of the animal
   * @throws IllegalArgumentException if the price is negative
   */
  public void setPrice(double price)
  {
    if (price < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }

  /**
   * Returns the sale status of the animal.
   *
   * @return true if the animal is for sale, false otherwise
   */
  public boolean isForSale()
  {
    return isForSale;
  }

  /**
   * Sets the sale status of the animal.
   *
   * @param isForSale the new sale status of the animal
   */
  public void setSaleStatus(boolean isForSale)
  {
    this.isForSale = isForSale;
  }

  /**
   * Returns the type of the animal.
   *
   * @return the type of the animal
   */
  public AnimalInfo getAnimalInfo()
  {
    return type;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param object the reference object with which to compare
   * @return true if this object is the same as the object argument; false otherwise
   */
  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    AnimalForSale that = (AnimalForSale) object;
    return Double.compare(price, that.price) == 0 && isForSale == that.isForSale
        && Objects.equals(type, that.type);
  }

  /**
   * Returns a string representation of the animal for sale.
   *
   * @return a string representation of the animal for sale
   */
  @Override public String toString()
  {
    return "AnimalForSale{" + "price='" + price + '\'' + ", isForSale='"
        + isForSale + '\'' + ", animalInfo=" + type.toString() + '}';
  }
}

package model;

import java.util.Objects;

/**
 * Class representing an owned animal with specific attributes such as name, food type, care status, type, and owner.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class OwnedAnimal
{
  private String name;
  private String foodType;
  private boolean isInCare;
  private AnimalInfo type;
  private Customer owner;

  /**
   * Constructs an OwnedAnimal with the specified attributes.
   *
   * @param animalType the type of the animal (e.g., "mammal", "fish", "reptile", "bird")
   * @param name the name of the animal
   * @param owner the owner of the animal
   * @param gender the gender of the animal ('M' or 'F')
   * @param age the age of the animal
   * @param species the species of the animal
   * @param extraInfo additional information specific to the animal type
   * @param extraInfo2 additional information specific to the animal type (used for birds)
   */
  public OwnedAnimal(String animalType, String name, Customer owner,
      char gender, int age, String species, boolean extraInfo,
      boolean extraInfo2)
  {
    this.name = name;
    this.owner = owner;
    this.foodType = "Standard";
    this.isInCare = false;

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
            extraInfo2); // Bird: extraInfo = tame, extraInfo2 = isTameable
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown animal type: " + animalType);
    }
  }

  /**
   * Constructs an OwnedAnimal with the specified name, owner, and type.
   *
   * @param name the name of the animal
   * @param owner the owner of the animal
   * @param type the type of the animal
   */
  public OwnedAnimal(String name, Customer owner, AnimalInfo type)
  {
    this.name = name;
    this.owner = owner;
    this.foodType = "Standard";
    this.isInCare = false;
    this.type = type;
  }

  /**
   * Returns the name of the animal.
   *
   * @return the name of the animal
   */
  public String getName()
  {
    return name;
  }

  /**
   * Returns the owner of the animal.
   *
   * @return the owner of the animal
   */
  public Customer getOwner()
  {
    return owner;
  }

  /**
   * Sets the type of food the animal eats.
   *
   * @param foodType the type of food the animal eats
   */
  public void setFoodType(String foodType)
  {
    this.foodType = foodType;
  }

  /**
   * Returns the type of food the animal eats.
   *
   * @return the type of food the animal eats
   */
  public String getFoodType()
  {
    return foodType;
  }

  /**
   * Puts the animal in care.
   */
  public void putInCare()
  {
    this.isInCare = true;
  }

  /**
   * Removes the animal from care.
   */
  public void removeFromCare()
  {
    this.isInCare = false;
  }

  /**
   * Returns whether the animal is in care.
   *
   * @return true if the animal is in care, false otherwise
   */
  public boolean isInCare()
  {
    return isInCare;
  }

  /**
   * Returns the animal information.
   *
   * @return the animal information
   */
  public AnimalInfo getAnimalInfo()
  {
    return type; // AKA animalInfo
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
    OwnedAnimal that = (OwnedAnimal) object;
    return isInCare == that.isInCare && Objects.equals(name, that.name)
        && Objects.equals(foodType, that.foodType) && Objects.equals(type,
        that.type);
  }

  /**
   * Returns a string representation of the owned animal.
   *
   * @return a string representation of the owned animal
   */
  @Override public String toString()
  {
    return "OwnedAnimal{" + "name='" + name + '\'' + ", foodType='" + foodType
        + '\'' + ", isInCare=" + isInCare + ", animalInfo=" + type.toString()
        + '}';
  }
}
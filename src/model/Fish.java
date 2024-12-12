package model;

import java.io.Serializable;

/**
 * Class representing a fish with specific attributes such as whether it lives in salt water.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Fish extends AnimalInfo implements Serializable
{
  private boolean saltWater;

  /**
   * Constructs a Fish with the specified attributes.
   *
   * @param gender the gender of the fish ('M' or 'F')
   * @param age the age of the fish
   * @param species the species of the fish
   * @param saltWater whether the fish lives in salt water
   */
  public Fish(char gender, int age, String species, boolean saltWater)
  {
    super(gender, age, species);
    this.saltWater = saltWater;
  }

  /**
   * Returns whether the fish lives in salt water.
   *
   * @return true if the fish lives in salt water, false otherwise
   */
  public boolean isSaltWater()
  {
    return saltWater;
  }

  /**
   * Returns a string representation of the fish.
   *
   * @return a string representation of the fish
   */
  @Override public String toString()
  {
    return "Fish " + super.toString() + " saltWater " + saltWater;
  }

  /**
   * Returns the type of the animal.
   *
   * @return the type of the animal
   */
  @Override public String getType()
  {
    return "Fish";
  }
}
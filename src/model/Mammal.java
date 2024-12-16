package model;

import java.io.Serializable;

/**
 * Class representing a mammal with specific attributes such as whether it is outdoor only.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Mammal extends AnimalInfo implements Serializable
{
  private boolean outdoorOnly;

  /**
   * Constructs a Mammal with the specified attributes.
   *
   * @param gender      the gender of the mammal ('M' or 'F')
   * @param age         the age of the mammal
   * @param species     the species of the mammal
   * @param outdoorOnly whether the mammal is outdoor only
   */
  public Mammal(char gender, int age, String species, boolean outdoorOnly)
  {
    super(gender, age, species);
    this.outdoorOnly = outdoorOnly;
  }

  /**
   * Returns whether the mammal is outdoor only.
   *
   * @return true if the mammal is outdoor only, false otherwise
   */
  public boolean isOutDoorOnly()
  {
    return outdoorOnly;
  }

  /**
   * Returns a string representation of the mammal.
   *
   * @return a string representation of the mammal
   */
  @Override public String toString()
  {
    return "Mammal - " + super.toString() + ", Only outdoors " + outdoorOnly;
  }

  /**
   * Returns the type of the animal.
   *
   * @return the type of the animal
   */
  @Override public String getType()
  {
    return "Mammal";
  }
}
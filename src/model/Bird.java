package model;

import java.io.Serializable;

/**
 * Class representing a bird with specific attributes such as tameness and tamability.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Bird extends AnimalInfo implements Serializable
{
  private boolean tame;
  private boolean isTameable;

  /**
   * Constructs a Bird with the specified attributes.
   *
   * @param gender     the gender of the bird ('M' or 'F')
   * @param age        the age of the bird
   * @param species    the species of the bird
   * @param tame       whether the bird is tame
   * @param isTameable whether the bird is tameable
   */
  public Bird(char gender, int age, String species, boolean tame,
      boolean isTameable)
  {
    super(gender, age, species);
    this.tame = tame;
    this.isTameable = isTameable;
  }

  /**
   * Returns whether the bird is tame.
   *
   * @return true if the bird is tame, false otherwise
   */
  public boolean isTame()
  {
    return tame;
  }

  /**
   * Returns whether the bird is tameable.
   *
   * @return true if the bird is tameable, false otherwise
   */
  public boolean isTameable()
  {
    return isTameable;
  }

  /**
   * Returns a string representation of the bird.
   *
   * @return a string representation of the bird
   */
  @Override public String toString()
  {
    return "Bird " + super.toString() + " tame " + tame + " isTameable "
        + isTameable;
  }

  /**
   * Returns the type of the animal.
   *
   * @return the type of the animal
   */
  @Override public String getType()
  {
    return "Bird";
  }
}

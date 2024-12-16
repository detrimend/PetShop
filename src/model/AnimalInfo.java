package model;

import java.io.Serializable;

/**
 * Abstract class representing general information about an animal.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public abstract class AnimalInfo implements Serializable
{
  private char gender;
  private int age;
  private String comment;
  private String species;

  /**
   * Constructs an AnimalInfo with the specified gender, age, and species.
   *
   * @param gender  the gender of the animal ('M' or 'F')
   * @param age     the age of the animal
   * @param species the species of the animal
   * @throws IllegalArgumentException if the gender is not 'M' or 'F', or if the age is negative
   */
  public AnimalInfo(char gender, int age, String species)
  {
    gender = Character.toUpperCase(gender);
    if (gender != 'M' && gender != 'F')
    {
      throw new IllegalArgumentException("Gender must be 'M' or 'F'");
    }
    if (age < 0)
    {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.gender = gender;
    this.age = age;
    this.species = species;
    this.comment = "";
  }

  /**
   * Adds a comment about the animal.
   *
   * @param newComment the comment to add
   */
  public void addComment(String newComment)
  {
    this.comment = newComment;
  }

  /**
   * Returns the age of the animal.
   *
   * @return the age of the animal
   */
  public int getAge()
  {
    return age;
  }

  /**
   * Returns the gender of the animal.
   *
   * @return the gender of the animal
   */
  public char getGender()
  {
    return gender;
  }

  /**
   * Returns the species of the animal.
   *
   * @return the species of the animal
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Returns the comment about the animal.
   *
   * @return the comment about the animal
   */
  public String getComment()
  {
    return comment;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare
   * @return true if this object is the same as the obj argument; false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof AnimalInfo)
    {
      AnimalInfo other = (AnimalInfo) obj;
      return this.species.equals(other.species);
    }
    return false;
  }

  /**
   * Returns a string representation of the animal information.
   *
   * @return a string representation of the animal information
   */
  public String toString()
  {
    return "Species " + species + " Age " + age + " Gender " + gender
        + " Comment " + comment;
  }

  /**
   * Returns the type of the animal.
   *
   * @return the type of the animal
   */
  public abstract String getType();
}

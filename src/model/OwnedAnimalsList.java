package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class representing a list of owned animals with various methods to manipulate and retrieve the list.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class OwnedAnimalsList implements Serializable
{
  private ArrayList<OwnedAnimal> animals;

  /**
   * Constructs an empty OwnedAnimalsList.
   */
  public OwnedAnimalsList()
  {
    this.animals = new ArrayList<>();
  }

  /**
   * Returns a list of all animals owned by the specified customer.
   *
   * @param customer the customer whose animals are to be retrieved
   * @return a list of animals owned by the specified customer
   */
  public OwnedAnimalsList getAnimalsByCustomer(Customer customer)
  {
    OwnedAnimalsList result = new OwnedAnimalsList();
    for (OwnedAnimal animal : animals)
    {
      if (animal != null && animal.getOwner().equals(customer))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  /**
   * Returns a list of all animals with the specified name.
   *
   * @param name the name of the animals to be retrieved
   * @return a list of animals with the specified name
   */
  public OwnedAnimalsList getAnimalsByName(String name)
  {
    OwnedAnimalsList result = new OwnedAnimalsList();
    for (OwnedAnimal animal : animals)
    {
      if (animal != null && animal.getName().equals(name))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  /**
   * Returns the animal at the specified index.
   *
   * @param index the index of the animal to be retrieved
   * @return the animal at the specified index
   */
  public OwnedAnimal getAnimalByIndex(int index)
  {
    return animals.get(index);
  }

  /**
   * Adds an animal to the list.
   *
   * @param ownedAnimal the animal to be added
   * @throws IllegalArgumentException if the animal is already on the list
   */
  public void addAnimal(OwnedAnimal ownedAnimal)
  {
    for (OwnedAnimal animal : animals)
    {
      if (animal.equals(ownedAnimal))
      {
        throw new IllegalArgumentException("Animal is already on the list");
      }
    }
    animals.add(ownedAnimal);
  }

  /**
   * Removes an animal from the list.
   *
   * @param ownedAnimal the animal to be removed
   * @return the removed animal
   * @throws IllegalArgumentException if the animal is in care and cannot be removed
   */
  public OwnedAnimal removeAnimal(OwnedAnimal ownedAnimal)
  {
    if (ownedAnimal.isInCare())
    {
      throw new IllegalArgumentException(
          "Animal is in care and cannot be removed");
    }
    animals.remove(ownedAnimal);
    return ownedAnimal;
  }

  /**
   * Returns the number of animals in the list.
   *
   * @return the number of animals in the list
   */
  public int getAmountOfAnimals()
  {
    return animals.size();
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
    OwnedAnimalsList that = (OwnedAnimalsList) object;
    return Objects.equals(animals, that.animals);
  }

  /**
   * Returns a string representation of the owned animals list.
   *
   * @return a string representation of the owned animals list
   */
  @Override public String toString()
  {
    return "OwnedAnimalsList{" + "animals=" + animals + '}';
  }
}
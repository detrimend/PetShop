package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class representing a list of animals for sale.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalsForSaleList
{
  private ArrayList<AnimalForSale> animals;

  /**
   * Constructs an empty AnimalsForSaleList.
   */
  public AnimalsForSaleList()
  {
    this.animals = new ArrayList<>();
  }

  /**
   * Returns a list of animals for sale filtered by type.
   *
   * @param type the type of animals to filter by
   * @return a list of animals for sale filtered by type
   */
  public AnimalsForSaleList getAnimalsByType(String type)
  {
    AnimalsForSaleList result = new AnimalsForSaleList();
    for (AnimalForSale animal : animals)
    {
      if (animal != null && animal.getAnimalInfo().getType().equals(type))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  /**
   * Returns a list of animals for sale filtered by species.
   *
   * @param species the species of animals to filter by
   * @return a list of animals for sale filtered by species
   */
  public AnimalsForSaleList getAnimalsBySpecies(String species)
  {
    AnimalsForSaleList result = new AnimalsForSaleList();
    for (AnimalForSale animal : animals)
    {
      if (animal != null && animal.getAnimalInfo().getSpecies().equals(species))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  /**
   * Adds an animal to the list of animals for sale.
   *
   * @param animalForSale the animal to add
   * @throws IllegalArgumentException if the animal is already on the list
   */
  public void addAnimal(AnimalForSale animalForSale)
  {
    for (AnimalForSale animal : animals)
    {
      if (animal.equals(animalForSale))
      {
        throw new IllegalArgumentException("Animal is already on the list");
      }
    }
    animals.add(animalForSale);
  }

  /**
   * Removes an animal from the list of animals for sale.
   *
   * @param animal the animal to remove
   */
  public void removeAnimal(AnimalForSale animal)
  {
    animals.remove(animal);
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
    if (!super.equals(object))
      return false;
    AnimalsForSaleList that = (AnimalsForSaleList) object;
    return Objects.equals(animals, that.animals);
  }

  /**
   * Returns a string representation of the list of animals for sale.
   *
   * @return a string representation of the list of animals for sale
   */
  @Override public String toString()
  {
    return "AnimalsForSaleList{" + "animals=" + animals + '}';
  }
}

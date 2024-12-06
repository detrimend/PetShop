package model;

import java.util.ArrayList;
import java.util.Objects;

public class OwnedAnimalsList
{
  private ArrayList<OwnedAnimal> animals;

  public OwnedAnimalsList()
  {
    this.animals = new ArrayList<>();
  }

  // Returnerer en liste med alle dyr på OwnedAnimals listen som deler model.Customer.
  public OwnedAnimalsList getAnimalsByCustomer(Customer customer)
      throws Exception
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

  // Returnerer en liste med alle dyr på OwnedAnimals listen som deler navn, i.e. samme string.
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

  public OwnedAnimal getAnimalByIndex(int index)
  {
    return animals.get(index);
  }

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

  public int getAmountOfAnimals()
  {
    return animals.size();
  }

  // Auto genererede equals og toString metoder.

  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    OwnedAnimalsList that = (OwnedAnimalsList) object;
    return Objects.equals(animals, that.animals);
  }

  @Override public String toString()
  {
    return "OwnedAnimalsList{" + "animals=" + animals + '}';
  }
}

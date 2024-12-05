import java.util.ArrayList;
import java.util.Objects;

public class AnimalsForSaleList
{
  private ArrayList<AnimalForSale> animals;

  public AnimalsForSaleList()
  {
    this.animals = new ArrayList<>();
  }

  public AnimalsForSaleList getAnimalsByType(String type) throws Exception
  {
    AnimalsForSaleList result = new AnimalsForSaleList();
    for(AnimalForSale animal : animals)
    {
      if(animal != null && animal.getAnimalInfo().getType().equals(type))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  public AnimalsForSaleList getAnimalsBySpecies(String species)
  {
    AnimalsForSaleList result = new AnimalsForSaleList();
    for(AnimalForSale animal : animals)
    {
      if(animal != null && animal.getAnimalInfo().getSpecies().equals(species))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  public void addAnimal(AnimalForSale animalForSale)
  {
    for(AnimalForSale animal : animals)
    {
      if (animal.equals(animalForSale))
      {
        throw new IllegalArgumentException("Animal is already on the list");
      }
    }
    animals.add(animalForSale);
  }

  // Auto genererede equals og toString metoder.

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

  @Override public String toString()
  {
    return "AnimalsForSaleList{" + "animals=" + animals + '}';
  }
}

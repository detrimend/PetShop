import java.util.ArrayList;
import java.util.Objects;

public class AnimalsForSaleList extends AnimalList
{
  private ArrayList<AnimalForSale> animals;

  public AnimalsForSaleList()
  {
    super();
  }

  public AnimalsForSaleList getAnimalsByType(String type) throws Exception
  {
    AnimalsForSaleList result = new AnimalsForSaleList();
    for(AnimalForSale animal : animals)
    {
      if(animal.getType().equals(type))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  public AnimalsForSaleList getAnimalsBySpecies(String species) throws Exception //SE NEDENFOR
  {
    AnimalsForSaleList result = new AnimalsForSaleList();
    for(AnimalForSale animal : animals)
    {
      if(animal.getSpecies().equals(species))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  // Ikke sikkert det her check er nødvendigt. Det gør det også nødvendigt at sige "throws Exception" i den ovenstående get metode.
  public void addAnimal(AnimalForSale animalForSale) throws Exception
  {
    for(AnimalForSale animal : animals)
    {
      if (animal.equals(animalForSale))
      {
        throw new Exception("Animal is already on the list");
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

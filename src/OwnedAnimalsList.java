import java.util.ArrayList;
import java.util.Objects;

public class OwnedAnimalsList
{
  private ArrayList<OwnedAnimal> animals;

  public OwnedAnimalsList()
  {
    super();
  }

  // Returnerer en liste med alle dyr på OwnedAnimals listen som deler Customer.
  public OwnedAnimalsList getAnimalsByCustomer(Customer customer)
      throws Exception
  {
    OwnedAnimalsList result = new OwnedAnimalsList();
    for(OwnedAnimal animal : animals)
    {
      if (animal.getCustomer().equals(customer))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  // Returnerer en liste med alle dyr på OwnedAnimals listen som deler navn, i.e. samme string.
  public OwnedAnimalsList getAnimalsByName(String name) throws Exception
  {
    OwnedAnimalsList result = new OwnedAnimalsList();
    for(OwnedAnimal animal : animals)
    {
      if (animal.getName().equals(name))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  public void addAnimal(OwnedAnimal ownedAnimal) throws Exception
  {
    for(OwnedAnimal animal : animals)
    {
      if (animal.equals(ownedAnimal))
      {
        throw new Exception("Animal is already on the list");
      }
    }
    animals.add(ownedAnimal);
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

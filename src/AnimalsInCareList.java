import java.util.ArrayList;
import java.util.Objects;

public class AnimalsInCareList extends AnimalList
{
  private ArrayList<OwnedAnimal> animals;
  private int maxAmountOfMammals;
  private int maxAmountOfOtherAnimals;
  private int amountOfMammals = 0; //TILFØJET
  private int amountOfOtherAnimals = 0; //TILFØJET

  public AnimalsInCareList()
  {
    super();
    this.maxAmountOfMammals = 30;
    this.maxAmountOfOtherAnimals = 10;
  }

  // Returnerer en liste med alle dyr på AnimalsInCare listen som deler Customer.
  public AnimalsInCareList getAnimalsByCustomer(Customer customer)
  {
    AnimalsInCareList result = new AnimalsInCareList();
    for(OwnedAnimal animal : animals)
    {
      if (animal.getCustomer().equals(customer))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  // Returnerer en liste med alle dyr på AnimalsInCare listen som deler navn, i.e. samme string.
  public AnimalsInCareList getAnimalsByName(String name)
  {
    AnimalsInCareList result = new AnimalsInCareList();
    for(OwnedAnimal animal : animals)
    {
      if (animal.getName().equals(name))
      {
        result.addAnimal(animal);
      }
    }
    return result;
  }

  /* Der er en del problemer med den her.
  De checks som laves kan skabe problemer når vi bruger klassen til at returnere
  dyr som filtrerede lister. Desuden tages der ikke højde for om det konkret
  er 30 Mammals og 10 andre dyr, eller om det er 30 *smådyr* og 10 andre ret
  specifikke undtagelser.
   */
  public void addAnimal(OwnedAnimal animalInCare)
  {
    if(animalInCare.getType().equals("Mammal"))
    {
      if(amountOfMammals < maxAmountOfMammals)
      {
        animals.add(animalInCare);
        amountOfMammals++;
      }
      // måske exception?
    }
    else
    {
      if (amountOfOtherAnimals < maxAmountOfOtherAnimals)
      {
        animals.add(animalInCare);
        amountOfOtherAnimals++;
      }
    }
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
    AnimalsInCareList that = (AnimalsInCareList) object;
    return Objects.equals(animals, that.animals);
  }

  @Override public String toString()
  {
    return "AnimalsInCareList{" + "animals=" + animals + '}';
  }
}

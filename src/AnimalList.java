import java.util.ArrayList;

public abstract class AnimalList
{
  private ArrayList<Animal> animals;

  public AnimalList()
  {
    this.animals = new ArrayList<>();
  }

  public int getNumberOfAnimals()
  {
    return animals.size();
  }

  public Animal getAnimal(int index)
  {
    return animals.get(index);
  }

  public boolean equals(Object obj)
  {
    // mangler
  }

  public String toString()
  {
    return animals.toString(); // hmm
  }


}

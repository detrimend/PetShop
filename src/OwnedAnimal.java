import java.util.Objects;

public class OwnedAnimal
{
  private String name;
  private String foodType;
  private boolean isInCare;
  private AnimalInfo type;

  public OwnedAnimal(String animalType, String name, String foodType, boolean isInCare,
      char gender, int age, String species, boolean extraInfo, boolean extraInfo2)
  {
    this.name = name;
    this.foodType = foodType;
    this.isInCare = isInCare;

    // Dynamisk oprettelse af AnimalInfo-subklasser baseret på animalType
    switch (animalType.toLowerCase())
    {
      case "mammal":
        this.type = new Mammal(gender, age, species, extraInfo); // Mammal: extraInfo = outdoorOnly
        break;
      case "fish":
        this.type = new Fish(gender, age, species, extraInfo); // Fish: extraInfo = saltWater
        break;
      case "reptile":
        this.type = new Reptile(gender, age, species, extraInfo); // Reptile: extraInfo = venomous
        break;
      case "bird":
        this.type = new Bird(gender, age, species, extraInfo, extraInfo2); // Bird: extraInfo = tame, extraInfo2 = isTamable
        break;
      default:
        throw new IllegalArgumentException("Unknown animal type: " + animalType);
    }
  }

  public String getName()
  {
    return name;
  }

  public String getFoodType()
  {
    return foodType;
  }

  public boolean isInCare()
  {
    return isInCare;
  }

  public AnimalInfo getAnimalInfo()
  {
    return type; // AKA animalInfo
  }

  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    OwnedAnimal that = (OwnedAnimal) object;
    return isInCare == that.isInCare && Objects.equals(name, that.name)
        && Objects.equals(foodType, that.foodType) && Objects.equals(type,
        that.type);
  }

  @Override
  public String toString()
  {
    return "OwnedAnimal{" +
        "name='" + name + '\'' +
        ", foodType='" + foodType + '\'' +
        ", isInCare=" + isInCare +
        ", animalInfo=" + type.toString() +
        '}';
  }
}



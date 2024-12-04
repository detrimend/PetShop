import java.util.Objects;

public class AnimalForSale
{
  private double price;
  private boolean isForSale; // Skal tilføjes til diagram
  private AnimalInfo type;

  public AnimalForSale(String animalType, double price, boolean isForSale,
      char gender, int age, String species, boolean extraInfo, boolean extraInfo2)
  {
    this.price = price;
    this.isForSale = true;

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

  public double getPrice()
  {
    return price;
  }

  // SKAL TILFØJES TIL DIAGRAMMET!!
  public void setPrice(double price)
  {
    this.price = price;
  }

  //Ændring fra diagrammet
  public void setSaleStatus(boolean isForSale)
  {
    this.isForSale = isForSale;
  }

  public AnimalInfo getAnimalInfo()
  {
    return type;
  }

  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    AnimalForSale that = (AnimalForSale) object;
    return Double.compare(price, that.price) == 0 && isForSale == that.isForSale
        && Objects.equals(type, that.type);
  }

  @Override
  public String toString()
  {
    return "AnimalForSale{" +
        "price='" + price + '\'' +
        ", isForSale='" + isForSale + '\'' +
        ", animalInfo=" + type.toString() +
        '}';
  }
}

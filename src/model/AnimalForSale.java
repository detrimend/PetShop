package model;

import java.util.Objects;

public class AnimalForSale
{
  private double price;
  private boolean isForSale;
  private AnimalInfo type;

  public AnimalForSale(String animalType, double price, boolean isForSale,
      char gender, int age, String species, boolean extraInfo,
      boolean extraInfo2)
  {
    if (price < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
    this.isForSale = true;

    // Dynamisk oprettelse af model.AnimalInfo-subklasser baseret på animalType
    switch (animalType.toLowerCase())
    {
      case "mammal":
        this.type = new Mammal(gender, age, species,
            extraInfo); // model.Mammal: extraInfo = outdoorOnly
        break;
      case "fish":
        this.type = new Fish(gender, age, species,
            extraInfo); // model.Fish: extraInfo = saltWater
        break;
      case "reptile":
        this.type = new Reptile(gender, age, species,
            extraInfo); // model.Reptile: extraInfo = venomous
        break;
      case "bird":
        this.type = new Bird(gender, age, species, extraInfo,
            extraInfo2); // model.Bird: extraInfo = tame, extraInfo2 = isTamable
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown animal type: " + animalType);
    }
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    if (price < 0)
    {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }

  public boolean isForSale()
  {
    return isForSale;
  }

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

  @Override public String toString()
  {
    return "AnimalForSale{" + "price='" + price + '\'' + ", isForSale='"
        + isForSale + '\'' + ", animalInfo=" + type.toString() + '}';
  }
}

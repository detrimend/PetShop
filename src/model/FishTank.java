package model;

public class FishTank
{
  public String foodType;
  public int numberOfFish;

  public FishTank(String foodType, int numberOfFish)
  {
    this.foodType = foodType;
    this.numberOfFish = numberOfFish;
  }

  public String getFoodType()
  {
    return foodType;
  }

  public int getNumberOfFish()
  {
    return numberOfFish;
  }

  @Override public boolean equals(Object obj)
  {
    if(this == obj)
      return true;
    if(obj == null || obj.getClass() != getClass())
      return false;
    FishTank fishTank = (FishTank) obj;
      return foodType.equals(fishTank.foodType) && numberOfFish == ((FishTank) obj).numberOfFish;
  }

  @Override public String toString()
  {
    return "Fiskene spiser: " + foodType + "\n" +  "Mængden af fisk til pasning" + numberOfFish;
  }
}

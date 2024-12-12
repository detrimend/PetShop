package model;

/**
 * Class representing a fish tank with specific attributes such as food type and number of fish.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class FishTank
{
  private String foodType;
  private int numberOfFish;

  /**
   * Constructs a FishTank with the specified food type and number of fish.
   *
   * @param foodType the type of food the fish eat
   * @param numberOfFish the number of fish in the tank
   */
  public FishTank(String foodType, int numberOfFish)
  {
    this.foodType = foodType;
    this.numberOfFish = numberOfFish;
  }

  /**
   * Returns the type of food the fish eat.
   *
   * @return the type of food the fish eat
   */
  public String getFoodType()
  {
    return foodType;
  }

  /**
   * Returns the number of fish in the tank.
   *
   * @return the number of fish in the tank
   */
  public int getNumberOfFish()
  {
    return numberOfFish;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare
   * @return true if this object is the same as the obj argument; false otherwise
   */
  @Override public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || obj.getClass() != getClass())
      return false;
    FishTank fishTank = (FishTank) obj;
    return foodType.equals(fishTank.foodType)
        && numberOfFish == fishTank.numberOfFish;
  }

  /**
   * Returns a string representation of the fish tank.
   *
   * @return a string representation of the fish tank
   */
  @Override public String toString()
  {
    return "Fiskene spiser: " + foodType + "\n" + "Mængden af fisk til pasning: "
        + numberOfFish;
  }
}
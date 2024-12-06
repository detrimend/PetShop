package model;

public class Fish extends AnimalInfo
{
  private boolean saltWater;

  public Fish(char gender, int age, String species, boolean saltWater)
  {
    super(gender, age, species);
    this.saltWater = saltWater;
  }

  public boolean isSaltWater()
  {
    return saltWater;
  }

  @Override public String toString()
  {
    return "Fish " + super.toString() + " saltWater " + saltWater;
  }

  @Override public String getType()
  {
    return "Fish";
  }

}

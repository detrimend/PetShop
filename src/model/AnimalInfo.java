package model;

public abstract class AnimalInfo
{
  private char gender;
  private int age;
  private String comment;
  private String species;

  public AnimalInfo(char gender, int age, String species)
  {
    gender = Character.toUpperCase(gender);
    if (gender != 'M' && gender != 'F')
    {
      throw new IllegalArgumentException("Gender must be 'M' or 'F'");
    }
    if (age < 0)
    {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.gender = gender;
    this.age = age;
    this.species = species;
    this.comment = "";
  }

  public void addComment(String newComment)
  {
    this.comment = newComment;
  }

  public int getAge()
  {
    return age;
  }

  public char getGender()
  {
    return gender;
  }

  public String getSpecies()
  {
    return species;
  }

  public String getComment()
  {
    return comment;
  }

  public boolean equals(Object obj)
  {
    if (obj instanceof AnimalInfo)
    {
      AnimalInfo other = (AnimalInfo) obj;
      return this.species.equals(other.species);
    }
    return false;
  }

  public String toString()
  {
    return "Species " + species + "Age " + age + " Gender " + gender
        + " Comment " + comment;
  }

  public abstract String getType();
}

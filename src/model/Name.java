package model;

public class Name
{
  private String firstName;
  private String lastName;
  private String fullName;

  public Name(String fullName)
  {
    this.fullName = fullName;
    String[] names = fullName.split(" ");
    this.firstName = names[0];
    this.lastName = names[1];
  }

  public Name(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  public String getFormalName()
  {
    return lastName + " , " + firstName;
  }

  public String toString()
  {
    return "kundens fornavn er: " + firstName + " og deres efternavn er: "
        + lastName;
  }

  @Override public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || obj.getClass() != getClass())
      return false;
    Name name = (Name) obj;
    return firstName.equals(name.firstName) && lastName.equals(name.lastName);
  }
}

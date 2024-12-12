package model;

/**
 * Class representing a name with first name, last name, and full name.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Name
{
  private String firstName;
  private String lastName;
  private String fullName;

  /**
   * Constructs a Name with the specified full name.
   *
   * @param fullName the full name of the person
   */
  public Name(String fullName)
  {
    this.fullName = fullName;
    String[] names = fullName.split(" ");
    this.firstName = names[0];
    this.lastName = names[1];
  }

  /**
   * Constructs a Name with the specified first name and last name.
   *
   * @param firstName the first name of the person
   * @param lastName the last name of the person
   */
  public Name(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of the person.
   *
   * @return the first name of the person
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Returns the last name of the person.
   *
   * @return the last name of the person
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * Returns the full name of the person.
   *
   * @return the full name of the person
   */
  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  /**
   * Returns the formal name of the person.
   *
   * @return the formal name of the person
   */
  public String getFormalName()
  {
    return lastName + " , " + firstName;
  }

  /**
   * Returns a string representation of the name.
   *
   * @return a string representation of the name
   */
  public String toString()
  {
    return getFullName();
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
    Name name = (Name) obj;
    return firstName.equals(name.firstName) && lastName.equals(name.lastName);
  }
}
package model;

import java.io.Serializable;

/**
 * Abstract class representing a person with a name and email.
 *
 * @author Martin Andersen
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public abstract class Person implements Serializable
{
  private Name name;
  private Email email;

  /**
   * Constructs a Person with the specified name and email.
   *
   * @param name the name of the person
   * @param email the email of the person
   */
  public Person(Name name, Email email)
  {
    setName(name);
    setEmail(email);
  }

  /**
   * Constructs a Person with the specified first name, last name, and email.
   *
   * @param firstName the first name of the person
   * @param lastName the last name of the person
   * @param email the email of the person
   */
  public Person(String firstName, String lastName, Email email)
  {
    setName(new Name(firstName, lastName));
    setEmail(email);
  }

  /**
   * Returns the name of the person.
   *
   * @return the name of the person
   */
  public Name getName()
  {
    return name;
  }

  /**
   * Returns the email of the person.
   *
   * @return the email of the person
   */
  public Email getEmail()
  {
    return email;
  }

  /**
   * Sets the name of the person.
   *
   * @param name the new name of the person
   */
  public void setName(Name name)
  {
    this.name = name;
  }

  /**
   * Sets the email of the person.
   *
   * @param email the new email of the person
   */
  public void setEmail(Email email)
  {
    this.email = email;
  }

  /**
   * Returns a string representation of the person.
   *
   * @return a string representation of the person
   */
  public String toString()
  {
    return "kundens navn er: " + name + "\n" + "kunden email er: " + email;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare
   * @return true if this object is the same as the obj argument; false otherwise
   */
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Person person = (Person) obj;
    return name.equals(person.name) && email.equals((person.email));
  }
}

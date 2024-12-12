package model;

import java.util.Objects;

/**
 * Class representing an email with a user, host, and domain.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Email
{
  private String user;
  private String host;
  private String domain;

  /**
   * Constructs an Email with the specified user, host, and domain.
   *
   * @param user the user part of the email
   * @param host the host part of the email
   * @param domain the domain part of the email
   */
  public Email(String user, String host, String domain)
  {
    this.user = user;
    this.host = host;
    this.domain = domain;
  }

  /**
   * Returns the user part of the email.
   *
   * @return the user part of the email
   */
  public String getUser()
  {
    return user;
  }

  /**
   * Returns the host part of the email.
   *
   * @return the host part of the email
   */
  public String getHost()
  {
    return host;
  }

  /**
   * Returns the domain part of the email.
   *
   * @return the domain part of the email
   */
  public String getDomain()
  {
    return domain;
  }

  /**
   * Returns a string representation of the email.
   *
   * @return a string representation of the email
   */
  @Override public String toString()
  {
    return user + "@" + host + "." + domain;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param object the reference object with which to compare
   * @return true if this object is the same as the object argument; false otherwise
   */
  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    Email email = (Email) object;
    return Objects.equals(user, email.user) && Objects.equals(host, email.host) && Objects.equals(domain, email.domain);
  }
}
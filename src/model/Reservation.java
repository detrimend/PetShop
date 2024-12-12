package model;

import java.time.LocalDate;

/**
 * Class representing a reservation with specific attributes such as date interval, price per animal, customer, animals, and comment.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class Reservation
{
  private DateInterval dateInterval;
  private double pricePerAnimal;
  private Customer customer;
  private OwnedAnimalsList animals;
  private String comment;

  /**
   * Constructs a Reservation with the specified date interval, customer, and animals.
   *
   * @param dateInterval the date interval of the reservation
   * @param customer the customer making the reservation
   * @param animals the list of animals being reserved
   * @throws IllegalArgumentException if any of the parameters are null
   */
  public Reservation(DateInterval dateInterval, Customer customer,
      OwnedAnimalsList animals)
  {
    if (dateInterval == null)
    {
      throw new IllegalArgumentException("DateInterval cannot be null");
    }
    if (customer == null)
    {
      throw new IllegalArgumentException("Customer cannot be null");
    }
    if (animals == null)
    {
      throw new IllegalArgumentException("OwnedAnimalsList cannot be null");
    }
    this.dateInterval = dateInterval.copy();
    this.pricePerAnimal = 50;
    this.customer = customer;
    this.animals = new OwnedAnimalsList();
    this.comment = "";
  }

  /**
   * Returns the date interval of the reservation.
   *
   * @return the date interval of the reservation
   */
  public DateInterval getDateInterval()
  {
    return dateInterval;
  }

  /**
   * Returns the customer making the reservation.
   *
   * @return the customer making the reservation
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * Returns the list of animals being reserved.
   *
   * @return the list of animals being reserved
   */
  public OwnedAnimalsList getAnimals()
  {
    return animals;
  }

  /**
   * Returns the price per day for the reservation.
   *
   * @return the price per day for the reservation
   */
  public double getPricePerDay()
  {
    return pricePerAnimal * animals.getAmountOfAnimals();
  }

  /**
   * Returns the total price for the reservation.
   *
   * @return the total price for the reservation
   */
  public double getTotalPrice()
  {
    return getPricePerDay() * getDateInterval().getDays();
  }

  /**
   * Sets the price per animal for the reservation.
   *
   * @param price the price per animal
   */
  public void setPrice(double price)
  {
    this.pricePerAnimal = price;
  }

  /**
   * Returns the end date of the reservation.
   *
   * @return the end date of the reservation
   */
  public LocalDate getEndDate()
  {
    return getDateInterval().getStartDate()
        .plusDays(getDateInterval().getDays());
  }

  /**
   * Returns the comment associated with the reservation.
   *
   * @return the comment associated with the reservation
   */
  public String getComment()
  {
    return comment;
  }

  /**
   * Edits the comment associated with the reservation.
   *
   * @param extraComment the additional comment to be added
   */
  public void editComment(String extraComment)
  {
    this.comment += extraComment;
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
    if (obj == null || getClass() != obj.getClass())
      return false;

    Reservation other = (Reservation) obj;
    return other.dateInterval.equals(this.dateInterval)
        && other.customer.equals(this.customer) && other.animals.equals(this.animals);
  }

  /**
   * Returns a string representation of the reservation.
   *
   * @return a string representation of the reservation
   */
  @Override public String toString()
  {
    return "Reservation{" + "dateInterval=" + dateInterval + ", pricePerAnimal="
        + pricePerAnimal + ", customer=" + customer + ", animals=" + animals
        + ", comment='" + comment + '\'' + '}';
  }
}
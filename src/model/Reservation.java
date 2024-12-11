package model;

import java.time.LocalDate;

public class Reservation
{
  private DateInterval dateInterval;
  private double pricePerAnimal;
  private Customer customer;
  private OwnedAnimalsList animals;
  private String comment;

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

  public DateInterval getDateInterval()
  {
    return dateInterval;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public OwnedAnimalsList getAnimals()
  {
    return animals;
  }

  public double getPricePerDay()
  {
    return pricePerAnimal * animals.getAmountOfAnimals();
  }

  public double getTotalPrice()
  {
    return getPricePerDay() * getDateInterval().getDays();
  }

  public void setPrice(double price)
  {
    setPrice(price);
  }

  public LocalDate getEndDate()
  {
    return getDateInterval().getStartDate()
        .plusDays(getDateInterval().getDays());
  }

  public String getComment()
  {
    return comment;
  }

  // Skal kigges på når vi er ved GUI
  public void editComment(String extraComment)
  {
    this.comment += extraComment;
  }

  @Override public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    Reservation other = (Reservation) obj;
    return other.dateInterval == this.dateInterval
        && other.customer == this.customer && other.animals == this.animals;
  }

  @Override public String toString()
  {
    return "Reservation{" + "dateInterval=" + dateInterval + ", pricePerAnimal="
        + pricePerAnimal + ", customer=" + customer + ", animals=" + animals
        + ", comment='" + comment + '\'' + '}';
  }
}

public class Reservation
{

  private DateInterval dateInterval;
  private int pricePerAnimal;
  private Customer customer;
  private OwnedAnimal ownedAnimal;

  public Reservation(DateInterval dateInterval, Customer customer,
      OwnedAnimal ownedAnimal)
  {
    this.dateInterval = dateInterval;
    this.pricePerAnimal = 50;
    this.customer = customer;
    this.ownedAnimal = ownedAnimal;
  }

  public DateInterval getDateInterval()
  {
    return dateInterval;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public AnimalList getAnimals()
  {
    return animalList;
  }

  public double getPricePerDay()
  {
    return pricePerAnimal;
  }

  public double getTotalPrice()
  {
    return getPricePerDay() * getDateInterval().getDays();
  }

  public void setDateInterval(DateInterval newDateInterval)
  {
    this.dateInterval = newDateInterval; // Kigger senere
  }

  @Override public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    Reservation other = (Reservation) obj;
    return other.dateInterval == this.dateInterval
        && other.customer == this.customer
        && other.ownedAnimal == this.ownedAnimal;
  }

  public void setPrice(double price)
  {
    setPrice(price);
  }

}

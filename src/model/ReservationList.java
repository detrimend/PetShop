package model;

import java.util.ArrayList;

public class ReservationList
{

  private ArrayList<Reservation> reservations;

  public ReservationList()
  {
    reservations = new ArrayList<>();
  }

    /* Er implementeret: Der skal laves en oprettes et OwnedAnimalList objekt med
    de dyr som skal stå på reservationen. Denne liste bruges så i addReservation.
    Skal implementeres: Tjek på om der er plads i pensionen i det indtastede
    DateInteval OG loop som skal ændre isInCare boolean på samtlige dyr på
    listen NÅR DateIntervallet/reservationen begynder (dvs. ikke endnu, hvis
    reservationen oprettes f.eks. 2 dage i forvejen)


    Ovenstående bliver til ny metode, handAnimalInForCare (eller sådan noget)
     */

  public boolean addReservation(DateInterval dateInterval, Customer customer,
      OwnedAnimalsList animals)
  {
    if (dateInterval == null || customer == null)
    {
      throw new IllegalArgumentException("Parameters cannot be null");
    }
    Reservation newReservation = new Reservation(dateInterval, customer,
        animals);

    return reservations.add(newReservation);
  }

  public void registerAnimalHandover(Reservation reservation)
  {
    OwnedAnimalsList incomingAnimals = reservation.getAnimals();
    for (int i = 0; i < incomingAnimals.getAmountOfAnimals(); i++)
    {
      if (incomingAnimals.getAnimalByIndex(i).isInCare() && incomingAnimals.getAnimalByIndex(i) != null)
      {
        throw new IllegalStateException("Animal is already registered as in care.");
      }
      incomingAnimals.getAnimalByIndex(i).putInCare();
    }
  }



  public void removeReservation(int index)
  {
    if (index >= 0 && index < reservations.size())
    {
      this.reservations.remove(index);
    }
    else
    {
      throw new IndexOutOfBoundsException("Index er OOB");
    }
  }

  public Reservation getReservation(int index)
  {
    if (index >= 0 && index < reservations.size())
    {
      return getReservation(index);
    }
    else
    {
      return null;
    }
  }

  public int getNumberOfReservations()
  {
    return reservations.size();
  }

  public Reservation getReservationByNumber(int phoneNumber)
  {
    for (Reservation res : reservations)
    {
      if (res.getCustomer().getPhoneNumber() == phoneNumber)
      { // Assumes model.Reservation has getReservationNumber()
        return res;
      }
    }

    return null;
  }

  public Reservation getReservationByName(String name)
  {
    for (Reservation res : reservations)
    {
      if (res.getCustomer().getName().equals(name))
      { // Assumes model.Reservation has getReservationNumber()
        return res;
      }
    }
    return null;
  }

  // Tilføj senere: Check "are you sure" besked eller sådan noget

  public Reservation endReservation(Reservation reservation)
  {
    for (Reservation r : reservations)
    {
      if (r.equals(reservation))
      {
        OwnedAnimalsList animalsGoingHome = r.getAnimals();
        for (int i = 0; i < animalsGoingHome.getAmountOfAnimals(); i++)
        {
          animalsGoingHome.getAnimalByIndex(i).removeFromCare();
        }
      }
    }
    return reservation;
  }

  public Reservation cancelReservation(Reservation reservation)
  {
    reservations.remove(reservation);
    return reservation;
  }

  public void addExistingReservation(Reservation reservation)
  {
    this.reservations.add(reservation);
  }

  @Override public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    ReservationList other = (ReservationList) obj;
    return other.reservations == this.reservations;
  }

  @Override public String toString()
  {
    return "ReservationList{" + "reservations=" + reservations + '}';
  }
}

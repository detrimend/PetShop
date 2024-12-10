package model;

import java.time.LocalDate;
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
    DateInteval
     */

  public boolean addReservation(DateInterval dateInterval, Customer customer,
      OwnedAnimalsList animals)
  {
    LocalDate newStart = dateInterval.getStartDate();
    LocalDate newEnd = newStart.plusDays(dateInterval.getDays() - 1);

    // Iterer gennem hver dag i det nye reservationsinterval
    for (LocalDate date = newStart; !date.isAfter(newEnd); date = date.plusDays(
        1))
    {
      int totalAnimals = animals.getAmountOfAnimals();

      /*
      POTENTIEL LØSNING PÅ AT ALLE ANIMALS BLANDES SAMMEN
      int totalSmallAnimals = 0;
      int totalOtherAnimals = 0;
      for (int i = 0; i < animals.getAmountOfAnimals(); i++)
      {
        if (animals.getAnimalByIndex(i).getAnimalInfo().getType()
            .equals("Mammal"))
        {
          totalSmallAnimals++;
        }
        else
        {
          totalOtherAnimals++;
        }
      }
       */

      // Tæl eksisterende gæster for samme dato
      for (Reservation existingReservation : reservations)
      {
        DateInterval existingInterval = existingReservation.getDateInterval();
        LocalDate existingStart = existingInterval.getStartDate();
        LocalDate existingEnd = existingStart.plusDays(
            existingInterval.getDays() - 1);

        if (!date.isBefore(existingStart) && !date.isAfter(existingEnd))
        {
          totalAnimals += existingReservation.getAnimals().getAmountOfAnimals();
        }
      }

      // Tjek om vi overstiger kapaciteten
      if (totalAnimals > 40)
      {
        return false; // Kapaciteten er overskredet
      }
    }
    Reservation newReservation = new Reservation(dateInterval, customer, animals);
    reservations.add(newReservation);
    return true; // Ingen kapacitetsproblemer fundet
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

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class representing a list of reservations with various methods to manipulate and retrieve the list.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class ReservationList implements Serializable
{
  private ArrayList<Reservation> reservations;

  /**
   * Constructs an empty ReservationList.
   */
  public ReservationList()
  {
    reservations = new ArrayList<>();
  }

  /**
   * Adds a reservation to the list if it does not exceed the capacity.
   *
   * @param dateInterval       the date interval of the reservation
   * @param customer           the customer making the reservation
   * @param animalsToPutInCare the list of animals being reserved
   * @return true if the reservation was added, false if it exceeds capacity
   */
  public boolean addReservation(DateInterval dateInterval, Customer customer,
      OwnedAnimalsList animalsToPutInCare)
  {
    LocalDate newStart = dateInterval.getStartDate(); // +1 assignment
    LocalDate newEnd = newStart.plusDays(dateInterval.getDays() - 1); // +1 assignment +1 for function

    // Iterate through each day in the new reservation interval
    for (LocalDate date = newStart; !date.isAfter(newEnd); date = date.plusDays(
        1)) // n for loop + 2 for assignment + 1 for comparing +1 for function
    {
      int totalAnimals = animalsToPutInCare.getAmountOfAnimals(); // +1 for assignment

      // Count existing guests for the same date
      for (Reservation existingReservation : reservations) //r for loop +1 for function +1 for assignment
      {
        DateInterval existingInterval = existingReservation.getDateInterval(); //+1 for assignment
        LocalDate existingStart = existingInterval.getStartDate(); //+1 for assignment
        LocalDate existingEnd = existingStart.plusDays(
            existingInterval.getDays() - 1); //+1 for assignment +1 for function

        if (!date.isBefore(existingStart) && !date.isAfter(existingEnd)) //+1 for comparing
        {
          totalAnimals += existingReservation.getAnimals().getAmountOfAnimals(); //+1 for assignment +1 for function
        }
      }

      // Check if capacity is exceeded
      if (totalAnimals > 40) //+ 1 for function
      {
        return false; // Capacity exceeded // +1 for return
      }
    }
    Reservation newReservation = new Reservation(dateInterval, customer,
        animalsToPutInCare); // +1 for assignment
    reservations.add(newReservation); // +1 for function
    return true; // No capacity issues found // +1 for return
  }

  // Detailed Time Complexity Analysis
  // ---------------------------------
  // Before loop +2 for assignment and +1 for function calling
  // Outer loop: n+4
  // Outer loop body: +1 assignment  +1 for function +1 for return
  // Inner loop : r +2
  // Inner loop body: +3 for assignment +1 for function and if the if is false +1 for assignment +1 for function
  // After Inner loop: +1 for function +1 for return
  // After outer loop: +1 for assignment +1 for function +1 for return


  // OuterLoop = n+7
  // InnerLoop =r+9
  // Function  = n*r+16
  // Dominating Term: O(n*r+16)
  // Complexity: O(m*r)

  /**
   * Registers the handover of animals for a reservation.
   *
   * @param reservation the reservation for which animals are handed over
   * @throws IllegalStateException if any animal is already registered as in care
   */
  public void registerAnimalHandover(Reservation reservation)
  {
    OwnedAnimalsList incomingAnimals = reservation.getAnimals();
    for (int i = 0; i < incomingAnimals.getAmountOfAnimals(); i++)
    {
      if (incomingAnimals.getAnimalByIndex(i).isInCare()
          && incomingAnimals.getAnimalByIndex(i) != null)
      {
        throw new IllegalStateException(
            "Animal is already registered as in care.");
      }
      incomingAnimals.getAnimalByIndex(i).putInCare();
    }
  }

  /**
   * Removes a reservation at the specified index.
   *
   * @param index the index of the reservation to be removed
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public void removeReservation(int index)
  {
    if (index >= 0 && index < reservations.size())
    {
      this.reservations.remove(index);
    }
    else
    {
      throw new IndexOutOfBoundsException("Index is out of bounds");
    }
  }

  /**
   * Returns the reservation at the specified index.
   *
   * @param index the index of the reservation to be retrieved
   * @return the reservation at the specified index, or null if the index is out of bounds
   */
  public Reservation getReservation(int index)
  {
    if (index >= 0 && index < reservations.size())
    {
      return reservations.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Returns the number of reservations in the list.
   *
   * @return the number of reservations in the list
   */
  public int getNumberOfReservations()
  {
    return reservations.size();
  }

  /**
   * Returns the reservation made by the customer with the specified phone number.
   *
   * @param phoneNumber the phone number of the customer
   * @return the reservation made by the customer, or null if no such reservation exists
   */
  public Reservation getReservationByNumber(int phoneNumber)
  {
    for (Reservation res : reservations)
    {
      if (res.getCustomer().getPhoneNumber() == phoneNumber)
      {
        return res;
      }
    }
    return null;
  }

  /**
   * Returns the reservation made by the customer with the specified name.
   *
   * @param name the name of the customer
   * @return the reservation made by the customer, or null if no such reservation exists
   */
  public Reservation getReservationByName(String name)
  {
    Name nameObj = new Name(name);
    for (Reservation res : reservations)
    {
      if (res.getCustomer().getName().equals(nameObj))
      {
        return res;
      }
    }
    return null;
  }

  /**
   * Ends a reservation and removes the animals from care.
   *
   * @param reservation the reservation to be ended
   * @return the ended reservation
   */
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

  /**
   * Cancels a reservation and removes it from the list.
   *
   * @param reservation the reservation to be canceled
   * @return the canceled reservation
   */
  public Reservation cancelReservation(Reservation reservation)
  {
    reservations.remove(reservation);
    return reservation;
  }

  /**
   * Adds an existing reservation to the list.
   *
   * @param reservation the reservation to be added
   */
  public void addExistingReservation(Reservation reservation)
  {
    this.reservations.add(reservation);
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

    ReservationList other = (ReservationList) obj;
    return other.reservations.equals(this.reservations);
  }

  /**
   * Returns a string representation of the reservation list.
   *
   * @return a string representation of the reservation list
   */
  @Override public String toString()
  {
    return "ReservationList{" + "reservations=" + reservations + '}';
  }
}
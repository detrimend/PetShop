package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class representing a date interval with a start date and a number of days.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class DateInterval implements Serializable
{
  private int days;
  private LocalDate startDate;

  /**
   * Constructs a DateInterval with the specified start date and number of days.
   *
   * @param startDate the start date of the interval
   * @param days the number of days in the interval
   */
  public DateInterval(LocalDate startDate, int days)
  {
    this.days = days;
    this.startDate = startDate;
  }

  /**
   * Returns whether the start date is before the current date.
   *
   * @return true if the start date is before the current date, false otherwise
   */
  public boolean isBefore()
  {
    return LocalDate.now().isBefore(startDate);
  }

  /**
   * Returns the number of days in the interval.
   *
   * @return the number of days in the interval
   */
  public int getDays()
  {
    return days;
  }

  /**
   * Returns the start date of the interval.
   *
   * @return the start date of the interval
   */
  public LocalDate getStartDate()
  {
    return startDate;
  }

  /**
   * Sets the start date and number of days of the interval.
   *
   * @param startDate the new start date of the interval
   * @param days the new number of days in the interval
   */
  public void set(LocalDate startDate, int days)
  {
    this.days = days;
    this.startDate = startDate;
  }

  /**
   * Returns a copy of this DateInterval.
   *
   * @return a copy of this DateInterval
   */
  public DateInterval copy()
  {
    return new DateInterval(this.startDate, this.days);
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

    DateInterval other = (DateInterval) obj;
    return other.days == this.days && (other.startDate != null
        && other.startDate.equals(this.startDate));
  }

  /**
   * Returns a string representation of the date interval.
   *
   * @return a string representation of the date interval
   */
  @Override public String toString()
  {
    return "DateInterval{" + "days=" + days + ", startDate=" + startDate + '}';
  }
}
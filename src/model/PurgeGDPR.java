package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class responsible for purging old customer data in compliance with GDPR regulations.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class PurgeGDPR implements Serializable
{
  private ReservationList reservationList;
  private PurchaseList purchaseList;
  private CustomerList customerList;

  /**
   * Constructs a PurgeGDPR with the specified reservation list, purchase list, and customer list.
   *
   * @param reservationList the list of reservations
   * @param purchaseList the list of purchases
   * @param customerList the list of customers
   */
  public PurgeGDPR(ReservationList reservationList, PurchaseList purchaseList,
      CustomerList customerList)
  {
    this.reservationList = reservationList;
    this.purchaseList = purchaseList;
    this.customerList = customerList;
  }

  /**
   * Removes customer data that is older than 5 years and has no recent reservations or purchases.
   */
  public void removeOldCustomerData()
  {
    for (int i = 0; i < customerList.getNumberOfCustomers(); i++)
    {
      Customer customer = customerList.getCustomerByIndex(i);
      boolean hasRecentReservation = false;
      boolean hasRecentPurchase = false;

      // Check for reservations within the last 5 years
      for (int j = 0; j < reservationList.getNumberOfReservations(); j++)
      {
        if (reservationList.getReservation(j).getCustomer().equals(customer)
            && reservationList.getReservation(j).getEndDate()
            .isAfter(LocalDate.now().minusYears(5)))
        {
          hasRecentReservation = true;
          break;
        }
      }

      // Check for purchases within the last 5 years
      for (int k = 0; k < purchaseList.getNumberOfPurchases(); k++)
      {
        if (purchaseList.getPurchase(k).getCustomer().equals(customer)
            && purchaseList.getPurchase(k).getDate()
            .isAfter(LocalDate.now().minusYears(5)))
        {
          hasRecentPurchase = true;
          break;
        }
      }

      // Remove customer if no recent reservations or purchases
      if (!hasRecentReservation && !hasRecentPurchase)
      {
        customerList.removeCustomer(customer);
        i--; // Adjust index after removal
      }
    }
  }
}
package model;

import java.time.LocalDate;

public class PurgeGDPR
{

  private ReservationList reservationList;
  private PurchaseList purchaseList;
  private CustomerList customerList;

  public PurgeGDPR(ReservationList reservationList, PurchaseList purchaseList,
      CustomerList customerList)
  {
    this.reservationList = reservationList;
    this.purchaseList = purchaseList;
    this.customerList = customerList;
  }

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


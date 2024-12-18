package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;

/**
 * Class responsible for purging old customer data in compliance with GDPR regulations.
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
   * @param purchaseList    the list of purchases
   * @param customerList    the list of customers
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
    if (reservationList == null || purchaseList == null || customerList == null)// +3 for null checks
      //+2
    {
      throw new IllegalArgumentException("Lists cannot be null"); //+1 for String
    }

    Iterator<Customer> iterator = customerList.iterator(); // 1 for the assignment
    while (iterator.hasNext())// n for the loop
    {
      Customer customer = iterator.next(); // +1 for the assignment
      boolean hasRecentReservation = false;//+1 for the assignment
      boolean hasRecentPurchase = false;//+1 for the assignment

      // Check for reservations within the last 5 years
      for (int j = 0; j < reservationList.getNumberOfReservations(); j++)//r for the loop +1 for the assignment
        //+1 for the comparison +1 for the addition
      {
        if (reservationList.getReservation(j).getCustomer().equals(customer)
            && reservationList.getReservation(j).getEndDate()
            .isAfter(LocalDate.now().minusYears(5)))//+1 for the comparring the two functions
          // +2 for the 2 functions and +1 for the assignment

        {
          hasRecentReservation = true; //+1 for assignment
          break; // +1 for function
        }
      }

      // Check for purchases within the last 5 years
      for (int k = 0; k < purchaseList.getNumberOfPurchases(); k++) //p for the loop +1 for the assignment
      //+1 for the comparison +1 for the addition
      {
        if (purchaseList.getPurchase(k).getCustomer().equals(customer)
            && purchaseList.getPurchase(k).getDate()
            .isAfter(LocalDate.now().minusYears(5))) //+1 for the comparring the two functions
        // +2 for the 2 functions and +1 for the assignment
        {
          hasRecentPurchase = true;//+1 for the assignment
          break;//+1 for the function
        }
      }

      // Remove customer if no recent reservations or purchases
      if (!hasRecentReservation && !hasRecentPurchase) //+1 for each comparison to check if element is found
      {
        iterator.remove();
      }
    }
    // Detailed Time Complexity Analysis
     // ---------------------------------
     // Before loop +3 for null checks and +2 for || and +1 for initialization
     // Outer loop: n+3
     // Inner loop 1: p+3
     // Inner loop 1 body: +1 for the comparing the two functions
    // +2 for the 2 functions and +1 for the assignment
    // +1 for function and +1 for assignment
    // Inner Loop 2: r+3
    // Inner Loop 2 Body:+1 for the comparing the two functions
    //+2 for the 2 functions and +1 for the assignment
    //+1 for function and +1 for assignment


    // OuterLoop = n+3
    // InnerLoop 1=p+9
    // InnerLoop 2=r+9
    // Function n3*(p9+r9)
    // Dominating Term: O(n3*(p9+r9)
    // Complexity: O(n*(p+r)

  }
}
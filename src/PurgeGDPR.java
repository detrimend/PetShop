import java.time.LocalDate;

public class PurgeGDPR {

  private ReservationList reservationList;
  private PurchaseList purchaseList;

  public PurgeGDPR(ReservationList reservationList, PurchaseList purchaseList)
  {
    this.reservationList = reservationList;
    this.purchaseList = purchaseList;
  }

  public void removeOldCustomerData()
  {
    for(int i = 0; i < reservationList.getNumberOfReservations(); i++)
    {
      if(reservationList.getReservation(i).getEndDate.)
    }
  }


}

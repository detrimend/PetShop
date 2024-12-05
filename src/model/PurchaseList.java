package model;

import java.util.ArrayList;

public class PurchaseList
{
  private ArrayList<Purchase> purchases;

  public PurchaseList()
  {
    this.purchases = new ArrayList<>();
  }

  public void addPurchases(Purchase purchase)
  {
    purchases.add(purchase);
  }
  public Purchase getPurchase(int index)
  {
    if (index >= 0 && index < purchases.size())
    {
      return purchases.get(index);
    }
    throw new IndexOutOfBoundsException("index out of bounds");
  }

  public int getNumberOfPurchases()
  {
    return purchases.size();
  }


  public Purchase getPurchaseByCustomer(Customer customer)
  {
    for (Purchase purchase : purchases)
    {
      if(purchase.getCustomer().equals(customer))

      {
        return purchase;
      }
    }
    return null;
  }
}

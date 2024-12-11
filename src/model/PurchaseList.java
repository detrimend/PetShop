package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class PurchaseList
{
  private ArrayList<Purchase> purchases;

  public PurchaseList()
  {
    this.purchases = new ArrayList<>();
  }

  public void addPurchase(Purchase purchase)
  {
    purchases.add(purchase);
  }

  public void addNewPurchase(Customer customer, LocalDate date,
      AnimalForSale animal, AnimalsForSaleList animalsForSaleList)
  {
    Purchase purchase = new Purchase(customer, date, animal,
        animalsForSaleList);
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
      if (purchase.getCustomer().equals(customer))

      {
        return purchase;
      }
    }
    return null;
  }

  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    PurchaseList that = (PurchaseList) o;
    return Objects.equals(purchases, that.purchases);
  }

  @Override public String toString()
  {
    return "PurchaseList{" + "purchases=" + purchases + '}';
  }
}

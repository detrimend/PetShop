package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class representing a list of purchases with various methods to manipulate and retrieve the list.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class PurchaseList implements Serializable
{
  private ArrayList<Purchase> purchases;

  /**
   * Constructs an empty PurchaseList.
   */
  public PurchaseList()
  {
    this.purchases = new ArrayList<>();
  }

  /**
   * Adds an existing purchase to the list.
   *
   * @param purchase the purchase to be added
   */
  public void addExistingPurchase(Purchase purchase)
  {
    purchases.add(purchase);
  }

  /**
   * Creates a new purchase, adds it to the list and assigns the purchased animal to the customer.
   *
   * @param customer               the customer making the purchase
   * @param animal                 the animal being purchased
   * @param nameForPurchasedAnimal the name to assign to the purchased animal
   */
  public void addNewPurchase(Customer customer, AnimalForSale animal,
      String nameForPurchasedAnimal)
  {
    Purchase purchase = new Purchase(customer, animal, nameForPurchasedAnimal);
    purchases.add(purchase);
  }

  /**
   * Returns the purchase at the specified index.
   *
   * @param index the index of the purchase to be retrieved
   * @return the purchase at the specified index
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public Purchase getPurchase(int index)
  {
    if (index >= 0 && index < purchases.size())
    {
      return purchases.get(index);
    }
    throw new IndexOutOfBoundsException("index out of bounds");
  }

  /**
   * Returns the number of purchases in the list.
   *
   * @return the number of purchases in the list
   */
  public int getNumberOfPurchases()
  {
    return purchases.size();
  }

  /**
   * Returns the purchase made by the specified customer.
   *
   * @param customer the customer whose purchase is to be retrieved
   * @return the purchase made by the specified customer, or null if no such purchase exists
   */
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

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare
   * @return true if this object is the same as the o argument; false otherwise
   */
  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    PurchaseList that = (PurchaseList) o;
    return Objects.equals(purchases, that.purchases);
  }

  /**
   * Returns a string representation of the purchase list.
   *
   * @return a string representation of the purchase list
   */
  @Override public String toString()
  {
    return "PurchaseList{" + "purchases=" + purchases + '}';
  }
}
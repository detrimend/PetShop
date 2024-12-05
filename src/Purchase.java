import java.time.LocalDate;

public class Purchase
{
  private LocalDate date;

  public Purchase(Customer customer, LocalDate date, AnimalForSale AnimalForSale)
  {
    this.date = date;
//føler jeg mangler noget her

  }

  public Customer getCustomer(Customer customer)
  {
    return customer;
  }

  public OwnedAnimal assignAnimalToCustomer(AnimalForSale animalForSale, Customer customer, String name)
  {
    OwnedAnimal ownedAnimal = new OwnedAnimal(name, animal);
    customer.addOwnedAnimal(ownedAnimal);
    return ownedAnimal;
  }

  public LocalDate getDate()
  {
    return date;
  }
}

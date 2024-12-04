import java.time.LocalDate;

public class Purchase
{
  private LocalDate date;

  public Purchase(Customer customer, LocalDate date, AnimalForSale Animal)
  {
    this.date = date;
//føler jeg mangler noget her

  }
  public OwnedAnimal assignAnimalToCustomer(AnimalForSale animal, Customer customer, String name)
  {
    OwnedAnimal ownedAnimal = new OwnedAnimal(name, animal);
    customer.addOwnedAnimal(ownedAnimal);
    return ownedAnimal;
  }

  public LocalDate getdate()
  {
    return date;
  }
}

package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import static jdk.jfr.internal.consumer.EventLog.update;

public class AnimalListViewModel
{
  private ObservableList<AnimalViewModel> list;
  private PetShopModel petShopModel;

  public AnimalListViewModel(PetShopModel petShopModel)
  {
    this.petShopModel = petShopModel;
    this.list = FXCollections.observableArrayList();

    update();
  }

  public void update()
  {
    list.clear();
    // til debug: System.out.println("AnimalList update() called");
    for (int i = 0; i < petShopModel.getNumberOfAnimalsForSale(); i++)
    {
      // til debug: System.out.println("Adding animal of index: " + i);
      list.add(new AnimalViewModel(petShopModel.getAnimalForSaleByIndex(i)));
    }

    for (int i = 0; i < petShopModel.getAmountOfAnimals(); i++)
    {
      list.add(new AnimalViewModel(petShopModel.getAnimalByIndex(i)));
    }


  }


  public ObservableList<AnimalViewModel> getList()
  {
    return list;
  }

  public void add(AnimalForSale animalForSale, OwnedAnimal ownedAnimal)
  {
    list.add(new AnimalViewModel(animalForSale));
    list.add(new AnimalViewModel(ownedAnimal));

  }
}
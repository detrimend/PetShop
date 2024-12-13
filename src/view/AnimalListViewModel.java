package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.PetShopModel;

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

  public update();
  {
    list.clear();
    for(int i = 0; i < petShopModel.getAmountOfAnimals(); i++)
    {
      list.add(new AnimalViewModel(petShopModel.getAnimalByIndex(i)))
    }
  }
}
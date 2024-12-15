package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OwnedAnimal;
import model.PetShopModel;

public class AnimalInCareViewModel
{
  private ObservableList<AnimalViewModel> list;
  private PetShopModel petShopModel;

  public AnimalInCareViewModel(PetShopModel petShopModel)
  {
    this.petShopModel = petShopModel;
    this.list = FXCollections.observableArrayList();

    update();
  }

  public void update()
  {
    list.clear();
    for (int i = 0; i < petShopModel.getAnimalsInCare().getAmountOfAnimals(); i++)
    {
      list.add(new AnimalViewModel(
          petShopModel.getAnimalsInCare().getAnimalByIndex(i)));
    }
  }

  public ObservableList<AnimalViewModel> getList()
  {
    return list;
  }

  public void add(OwnedAnimal ownedAnimal)
  {
    list.add(new AnimalViewModel(ownedAnimal));
  }
}

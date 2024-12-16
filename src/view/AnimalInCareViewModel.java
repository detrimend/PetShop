package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OwnedAnimal;
import model.PetShopModel;

/**
 * ViewModel class for the Animals in Care.
 * It provides an observable list of AnimalViewModel for binding to the view.
 * This class is responsible for managing the list of animals currently in care.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalInCareViewModel
{
  private ObservableList<AnimalViewModel> list;
  private PetShopModel petShopModel;

  /**
   * Constructs an AnimalInCareViewModel with the specified model.
   *
   * @param petShopModel the model to interact with the data
   */
  public AnimalInCareViewModel(PetShopModel petShopModel)
  {
    this.petShopModel = petShopModel;
    this.list = FXCollections.observableArrayList();

    update();
  }

  /**
   * Updates the list of animals in care from the model.
   * It clears the current list and repopulates it with the latest data.
   */
  public void update()
  {
    list.clear();
    for (int i = 0; i < petShopModel.getAnimalsInCare().getAmountOfAnimals(); i++)
    {
      list.add(new AnimalViewModel(
          petShopModel.getAnimalsInCare().getAnimalByIndex(i)));
    }
  }

  /**
   * Returns the observable list of AnimalViewModel.
   *
   * @return the observable list of AnimalViewModel
   */
  public ObservableList<AnimalViewModel> getList()
  {
    return list;
  }

  /**
   * Adds a new owned animal to the list.
   *
   * @param ownedAnimal the owned animal to be added
   */
  public void add(OwnedAnimal ownedAnimal)
  {
    list.add(new AnimalViewModel(ownedAnimal));
  }
}
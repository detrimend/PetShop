package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

/**
 * ViewModel class for the Animal List.
 * It provides an observable list of AnimalViewModel for binding to the view.
 * This class is responsible for managing the list of animals in the system.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalListViewModel
{
  private ObservableList<AnimalViewModel> list;
  private PetShopModel petShopModel;

  /**
   * Constructs an AnimalListViewModel with the specified model.
   *
   * @param petShopModel the model to interact with the data
   */
  public AnimalListViewModel(PetShopModel petShopModel)
  {
    this.petShopModel = petShopModel;
    this.list = FXCollections.observableArrayList();

    update();
  }

  /**
   * Updates the list of animals from the model.
   * It clears the current list and repopulates it with the latest data.
   */
  public void update()
  {
    list.clear();
    for (int i = 0; i < petShopModel.getNumberOfAnimalsForSale(); i++)
    {
      list.add(new AnimalViewModel(petShopModel.getAnimalForSaleByIndex(i)));
    }

    for (int i = 0; i < petShopModel.getAmountOfAnimals(); i++)
    {
      list.add(new AnimalViewModel(petShopModel.getAnimalByIndex(i)));
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
   * Adds a new animal to the list.
   *
   * @param animalForSale the animal for sale to be added
   * @param ownedAnimal the owned animal to be added
   */
  public void add(AnimalForSale animalForSale, OwnedAnimal ownedAnimal)
  {
    list.add(new AnimalViewModel(animalForSale));
    list.add(new AnimalViewModel(ownedAnimal));
  }
}
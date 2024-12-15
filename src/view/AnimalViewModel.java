package view;

import javafx.beans.property.*;
import model.*;

/**
 * ViewModel class for Animal.
 * It provides properties for binding animal data to the view.
 * This class is used to represent an animal in the view.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalViewModel
{
  private StringProperty genderProperty;
  private StringProperty nameProperty;
  private StringProperty typeProperty;
  private StringProperty speciesProperty;
  private IntegerProperty ageProperty;
  private StringProperty extraInfoProperty;
  private StringProperty extraInfo2Property;
  private DoubleProperty priceProperty;
  private StringProperty forSaleProperty;

  /**
   * Constructs an AnimalViewModel with the specified animal for sale.
   *
   * @param animalForSale the animal for sale to be represented by this ViewModel
   */
  public AnimalViewModel(AnimalForSale animalForSale)
  {
    genderProperty = new SimpleStringProperty(
        String.valueOf(animalForSale.getAnimalInfo().getGender()));
    typeProperty = new SimpleStringProperty(
        animalForSale.getAnimalInfo().getType());
    speciesProperty = new SimpleStringProperty(
        animalForSale.getAnimalInfo().getSpecies());
    ageProperty = new SimpleIntegerProperty(
        animalForSale.getAnimalInfo().getAge());
    switch (animalForSale.getAnimalInfo().getType().toLowerCase())
    {
      case "mammal":
        Mammal mammal = (Mammal) animalForSale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(mammal.isOutDoorOnly()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "fish":
        Fish fish = (Fish) animalForSale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(fish.isSaltWater()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "reptile":
        Reptile reptile = (Reptile) animalForSale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(reptile.isVenomous()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "bird":
        Bird bird = (Bird) animalForSale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(bird.isTame()));
        extraInfo2Property = new SimpleStringProperty(
            String.valueOf(bird.isTameable()));
        break;
      default:
        extraInfoProperty = new SimpleStringProperty("false");
        extraInfo2Property = new SimpleStringProperty("false");
    }
    priceProperty = new SimpleDoubleProperty(animalForSale.getPrice());
    forSaleProperty = new SimpleStringProperty(
        String.valueOf(animalForSale.isForSale()));
  }

  /**
   * Constructs an AnimalViewModel with the specified owned animal.
   *
   * @param ownedAnimal the owned animal to be represented by this ViewModel
   */
  public AnimalViewModel(OwnedAnimal ownedAnimal)
  {
    genderProperty = new SimpleStringProperty(
        String.valueOf(ownedAnimal.getAnimalInfo().getGender()));
    typeProperty = new SimpleStringProperty(
        ownedAnimal.getAnimalInfo().getType());
    speciesProperty = new SimpleStringProperty(
        ownedAnimal.getAnimalInfo().getSpecies());
    ageProperty = new SimpleIntegerProperty(
        ownedAnimal.getAnimalInfo().getAge());

    switch (ownedAnimal.getAnimalInfo().getType().toLowerCase())
    {
      case "mammal":
        Mammal mammal = (Mammal) ownedAnimal.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(mammal.isOutDoorOnly()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "fish":
        Fish fish = (Fish) ownedAnimal.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(fish.isSaltWater()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "reptile":
        Reptile reptile = (Reptile) ownedAnimal.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(reptile.isVenomous()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "bird":
        Bird bird = (Bird) ownedAnimal.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(bird.isTame()));
        extraInfo2Property = new SimpleStringProperty(
            String.valueOf(bird.isTameable()));
        break;
      default:
        extraInfoProperty = new SimpleStringProperty("false");
        extraInfo2Property = new SimpleStringProperty("false");
    }

    priceProperty = new SimpleDoubleProperty(
        0); // Owned animals usually have no price
    forSaleProperty = new SimpleStringProperty("Owned"); // Status as "Owned"

    // Owned animals should have a name
    nameProperty = new SimpleStringProperty(ownedAnimal.getName());
  }

  /**
   * Returns the gender property.
   *
   * @return the gender property
   */
  public StringProperty getGenderProperty()
  {
    return genderProperty;
  }

  /**
   * Returns the name property.
   *
   * @return the name property
   */
  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  /**
   * Returns the type property.
   *
   * @return the type property
   */
  public StringProperty getTypeProperty()
  {
    return typeProperty;
  }

  /**
   * Returns the species property.
   *
   * @return the species property
   */
  public StringProperty getSpeciesProperty()
  {
    return speciesProperty;
  }

  /**
   * Returns the age property.
   *
   * @return the age property
   */
  public IntegerProperty getAgeProperty()
  {
    return ageProperty;
  }

  /**
   * Returns the extra info property.
   *
   * @return the extra info property
   */
  public StringProperty getExtraInfoProperty()
  {
    return extraInfoProperty;
  }

  /**
   * Returns the extra info2 property.
   *
   * @return the extra info2 property
   */
  public StringProperty getExtraInfo2Property()
  {
    return extraInfo2Property;
  }

  /**
   * Returns the price property.
   *
   * @return the price property
   */
  public DoubleProperty getPriceProperty()
  {
    return priceProperty;
  }

  /**
   * Returns the for sale property.
   *
   * @return the for sale property
   */
  public StringProperty getForSaleProperty()
  {
    return forSaleProperty;
  }
}
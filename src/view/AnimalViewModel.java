package view;

import javafx.beans.property.*;
import model.*;

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


  public AnimalViewModel(AnimalForSale animalforsale)

  {
    genderProperty = new SimpleStringProperty(String.valueOf(animalforsale.getAnimalInfo().getGender()));
    typeProperty = new SimpleStringProperty(animalforsale.getAnimalInfo().getType());
    speciesProperty = new SimpleStringProperty(animalforsale.getAnimalInfo().getSpecies());
    ageProperty = new SimpleIntegerProperty(animalforsale.getAnimalInfo().getAge());
    switch (animalforsale.getAnimalInfo().getType().toLowerCase())
    {
      case "mammal":
        Mammal mammal = (Mammal) animalforsale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(mammal.isOutDoorOnly()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "fish":
        Fish fish = (Fish) animalforsale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(fish.isSaltWater()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "reptile":
        Reptile reptile = (Reptile) animalforsale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(reptile.isVenomous()));
        extraInfo2Property = new SimpleStringProperty("false");
        break;
      case "bird":
        Bird bird = (Bird) animalforsale.getAnimalInfo();
        extraInfoProperty = new SimpleStringProperty(
            String.valueOf(bird.isTame()));
        extraInfo2Property = new SimpleStringProperty(
            String.valueOf(bird.isTameable()));
        break;
      default:
        extraInfoProperty = new SimpleStringProperty("false");
        extraInfo2Property = new SimpleStringProperty("false");
    }
    priceProperty = new SimpleDoubleProperty(animalforsale.getPrice());
    nameProperty = new SimpleStringProperty("Martin");
    forSaleProperty = new SimpleStringProperty(String.valueOf(animalforsale.isForSale()));
  }

  public StringProperty getGenderProperty()
  {
    return genderProperty;
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  public StringProperty getTypeProperty()
  {
    return typeProperty;
  }

  public StringProperty getSpeciesProperty()
  {
    return speciesProperty;
  }

  public IntegerProperty getAgeProperty()
  {
    return ageProperty;
  }

  public StringProperty getExtraInfoProperty()
  {
    return extraInfoProperty;
  }

  public StringProperty getExtraInfo2Property()
  {
    return extraInfo2Property;
  }

  public DoubleProperty getPriceProperty()
  {
    return priceProperty;
  }

  public StringProperty getForSaleProperty()
  {
    return forSaleProperty;
  }


}
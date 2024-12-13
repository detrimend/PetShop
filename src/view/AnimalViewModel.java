package view;

import javafx.beans.property.*;
import model.AnimalForSale;
import model.AnimalInfo;
import model.OwnedAnimal;

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

  public AnimalViewModel(AnimalForSale animalforsale, AnimalInfo animalinfo, OwnedAnimal ownedAnimal)

  {
    genderProperty = new SimpleStringProperty();
    typeProperty = new SimpleStringProperty(animalinfo.getType());
    speciesProperty = new SimpleStringProperty(animalinfo.getSpecies());
    ageProperty = new SimpleIntegerProperty(animalinfo.getAge());
    extraInfoProperty = new SimpleStringProperty();
    extraInfo2Property = new SimpleStringProperty();
    priceProperty = new SimpleDoubleProperty(animalforsale.getPrice());
    nameProperty = new SimpleStringProperty(ownedAnimal.getName());
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
  public StringProperty getName
}
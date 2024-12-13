package view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.PetShopModel;

import javax.annotation.processing.Generated;
import java.awt.*;

import javax.swing.*;

public class AddAnimalViewController
{
  @FXML TextField priceField;
  @FXML TextField ageField;
  @FXML TextField extraInfoField;
  @FXML TextField extraInfo2Field;
  @FXML TextField speciesField;
  @FXML ComboBox<String> typeBox;
  @FXML ComboBox<String> genderBox;
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
    genderBox.getItems().addAll("Male","Female");
    typeBox.getItems().addAll("Fish","Mammal","Bird","Reptile");

  }



  public void reset()
  {
    priceField.setText("");
    extraInfoField.setText("");
    extraInfo2Field.setText("");
    speciesField.setText("");
    typeBox.getItems().clear();
    typeBox.getItems().addAll();
  }

  @FXML private void addButton()
  {
    try
    {

      petShopModel.addAnimal(priceField.getText(),speciesField.getText(),extraInfoField.getText(),extraInfo2Field.getText(),typeBox.getValue(),typeBox.getValue());
      viewHandler.openView("animalList");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @FXML private void BackButton()
  {
    try
    {
      viewHandler.openView("forside");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}




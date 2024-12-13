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
  @FXML ComboBox<String> extraInfoBox;
  @FXML ComboBox<String> extraInfo2Box;
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
    extraInfoBox.getItems().addAll("true","false");
    extraInfo2Box.getItems().addAll("true","false");
  }



  public void reset()
  {
    priceField.setText("");
    extraInfoBox.getItems().clear();
    extraInfo2Box.getItems().clear();
    speciesField.setText("");
    typeBox.getItems().clear();
    typeBox.getItems().addAll();
  }

  @FXML private void addButton()
  {
    try
    {

      petShopModel.addNewAnimalForSaleWithStrings(typeBox.getValue()
          ,priceField.getText(),genderBox.getValue()
          ,ageField.getText(),speciesField.getText()
          ,extraInfoBox.getValue(),extraInfo2Box.getValue());

      viewHandler.openView("AnimalList");
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




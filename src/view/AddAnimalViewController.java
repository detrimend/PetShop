package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.PetShopModel;

import javax.annotation.processing.Generated;
import java.awt.*;

public class AddAnimalViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
  }
  @FXML
  private void BackButton() {
    try {
      viewHandler.openView("forside");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}




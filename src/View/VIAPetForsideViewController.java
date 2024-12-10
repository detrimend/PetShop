package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.PetShopModel;

public class VIAPetForsideViewController
{
  @FXML private TextField inputField;
  @FXML private Label errorLabel;
  private Region root;
  private PetShopModel petShopModel;
  private ViewHandler viewHandler;

  public VIAPetForsideViewController()
  {

  }

  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.petShopModel = petShopModel;
    this.root = root;
  }

  public Region getRoot()
  {
    return root;
  }
@FXML private void handleButtonClick()
{
try {

  viewHandler.openView("forside");
  }
    catch (Exception e) {
  e.printStackTrace();
  }
}

}



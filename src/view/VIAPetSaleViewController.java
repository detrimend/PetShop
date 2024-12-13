package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.PetShopModel;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class VIAPetSaleViewController
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
  private void addCustomerButton() {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VIAPetNewCustomer.fxml"));
      Parent root = fxmlLoader.load();
      VIAPetNewCustomerViewController controller = fxmlLoader.getController();
      controller.init(viewHandler, petShopModel, null); // Bemærk at "Region root" kan sættes til null eller noget relevant

      Stage newStage = new Stage();
      newStage.setTitle("Add Customer");//set titlen
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  @FXML private void refreshButton()
  {
    try
    {
      viewHandler.openView("Sale");
    }
    catch (Exception e)
    {
    }
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

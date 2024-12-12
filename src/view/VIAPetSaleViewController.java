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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VIAPetNewCustomer.fxml")); // vælg path
            Parent root = fxmlLoader.load();

            Stage newStage = new Stage();
            newStage.setTitle("Add Customer");  //set titlen
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
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

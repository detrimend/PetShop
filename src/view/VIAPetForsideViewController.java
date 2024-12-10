package view;

import javafx.event.ActionEvent; // Correct import for JavaFX ActionEvent
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.PetShopModel;

import java.io.IOException;

public class VIAPetForsideViewController
{

  private Stage stage;
  private Scene scene;
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
    this.stage = stage;
    this.scene = scene;
  }

  @FXML
  private void SaleButton() {
    try {
      viewHandler.openView("Sale");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void CareButton() {
    try {
      viewHandler.openView("Care");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void NewCustomerButton() {
    try {
      viewHandler.openView("NewCustomer");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void CustomerListButton() {
    try {
      viewHandler.openView("CustomerList");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void AnimalListButton() {
    try {
      viewHandler.openView("AnimalList");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void AnimalForSaleButton() {
    try {
      viewHandler.openView("AnimalSale");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
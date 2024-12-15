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

/**
 * Controller class for the Animal Sale Confirmation view.
 * It handles the user interactions and updates the view accordingly.
 * This class is responsible for confirming the sale of an animal.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalSaleConfirmViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  /**
   * Initializes the controller with the specified view handler, model, and root region.
   *
   * @param viewHandler the view handler to manage view transitions
   * @param petShopModel the model to interact with the data
   * @param root the root region of the view
   */
  public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
  }

  /**
   * Handles the action of the back button.
   * It navigates back to the previous view.
   */
  @FXML
  private void BackButton() {
    try {
      viewHandler.openView("forside");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
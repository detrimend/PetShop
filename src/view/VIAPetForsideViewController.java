package view;

import javafx.event.ActionEvent; // Correct import for JavaFX ActionEvent
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class VIAPetForsideViewController {

  private Stage stage;
  private Scene scene;
  private Parent root;

  // Switches to the sale scene
  public void switchToSaleScene(ActionEvent event) throws IOException {
    // Load the new FXML file
    root = FXMLLoader.load(getClass().getResource("VIAPetSale.fxml"));

    // Get the stage from the event source
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Create a new scene and set it on the stage
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); // Display the updated stage
  }
  public void switchToCareScene(ActionEvent event) throws IOException {
    // Load the new FXML file
    root = FXMLLoader.load(getClass().getResource("VIAPetCare.fxml"));

    // Get the stage from the event source
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Create a new scene and set it on the stage
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); // Display the updated stage
  }
  public void switchToCustomerListScene(ActionEvent event) throws IOException {
    // Load the new FXML file
    root = FXMLLoader.load(getClass().getResource("VIAPetCustomerList.fxml"));

    // Get the stage from the event source
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Create a new scene and set it on the stage
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); // Display the updated stage
  }
  public void switchToNewCustomerScene(ActionEvent event) throws IOException {
    // Load the new FXML file
    root = FXMLLoader.load(getClass().getResource("VIAPetNewCustomer.fxml"));

    // Get the stage from the event source
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Create a new scene and set it on the stage
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); // Display the updated stage
  }
  public void switchToAnimalListScene(ActionEvent event) throws IOException {
    // Load the new FXML file
    root = FXMLLoader.load(getClass().getResource("VIAPetAnimalList.fxml"));

    // Get the stage from the event source
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Create a new scene and set it on the stage
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); // Display the updated stage
  }
  public void switchToAnimalSaleScene(ActionEvent event) throws IOException {
    // Load the new FXML file
    root = FXMLLoader.load(getClass().getResource("VIAPetAddAnimal.fxml"));

    // Get the stage from the event source
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Create a new scene and set it on the stage
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); // Display the updated stage
  }

}
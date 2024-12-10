package view;
import javafx.event.ActionEvent; // Correct import for JavaFX ActionEvent
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class VIApetSaleViewController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Switches to the sale scene
    public void switchToAnimalConfirmScene(ActionEvent event) throws IOException {
        // Load the new FXML file
        root = FXMLLoader.load(getClass().getResource("AnimalSaleConfirm.fxml"));

        // Get the stage from the event source
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Create a new scene and set it on the stage
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); // Display the updated stage
    }
}

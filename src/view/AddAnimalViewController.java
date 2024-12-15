package view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.PetShopModel;

/**
 * Controller class for the Add Animal view.
 * It handles the user interactions and updates the view accordingly.
 * This class is responsible for adding a new animal to the system.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
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

  /**
   * Initializes the controller with the specified view handler, model, and root region.
   *
   * @param viewHandler the view handler to manage view transitions
   * @param petShopModel the model to interact with the data
   * @param root the root region of the view
   */
  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
    genderBox.getItems().addAll("Male", "Female");
    typeBox.getItems().addAll("Fish", "Mammal", "Bird", "Reptile");
    extraInfoBox.getItems().addAll("true", "false");
    extraInfo2Box.getItems().addAll("true", "false");
  }

  /**
   * Resets the input fields to their default state.
   */
  public void reset()
  {
    priceField.setText("");
    extraInfoBox.getItems().clear();
    extraInfo2Box.getItems().clear();
    speciesField.setText("");
    typeBox.getItems().clear();
    genderBox.getItems().clear();
    ageField.setText("");
  }

  /**
   * Handles the action of the add button.
   * It adds a new animal to the system and navigates to the animal list view.
   */
  @FXML private void addButton()
  {
    try
    {
      petShopModel.addNewAnimalForSaleWithStrings(typeBox.getValue(),
          priceField.getText(), genderBox.getValue(), ageField.getText(),
          speciesField.getText(), extraInfoBox.getValue(),
          extraInfo2Box.getValue());

      viewHandler.openView("AnimalList");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * Handles the action of the back button.
   * It navigates back to the previous view.
   */
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
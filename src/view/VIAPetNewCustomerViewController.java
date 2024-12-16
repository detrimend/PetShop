package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.PetShopModel;

/**
 * Controller class for the New Customer view.
 * It handles the user interactions and updates the view accordingly.
 * This class is responsible for creating a new customer in the system.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class VIAPetNewCustomerViewController
{
  @FXML TextField firstNameField;
  @FXML TextField lastNameField;
  @FXML TextField emailField;
  @FXML TextField phoneNumberField;

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
  }

  /**
   * Resets the input fields to their default state.
   */
  public void reset()
  {
    firstNameField.setText("");
    lastNameField.setText("");
    emailField.setText("");
    phoneNumberField.setText("");
  }

  /**
   * Handles the action of the create button.
   * It creates a new customer and navigates to the main view.
   */
  @FXML private void CreateButton()
  {
    try
    {
      petShopModel.addCustomer(firstNameField.getText(),
          lastNameField.getText(), emailField.getText(),
          phoneNumberField.getText());
      viewHandler.openView("forside");
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

  /*@FXML Kode der kan vises til eksamen på hvad vi prøvet på
  private void CreateButton() {
    boolean OpenNewTab = true;

    try {
      petShopModel.addCustomer(
              firstNameField.getText(),
              lastNameField.getText(),
              emailField.getText(),
              phoneNumberField.getText()
      );

      if (OpenNewTab) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViaPetNewCustomer.fxml"));
        Region root = fxmlLoader.load();
        VIAPetNewCustomerViewController controller = fxmlLoader.getController();
        controller.init(viewHandler, petShopModel, root);

        Stage newStage = new Stage();
        newStage.setTitle("Add Customer");
        newStage.show();

        Stage currentStage = (Stage) firstNameField.getScene().getWindow();
        currentStage.close();
      } else {
        viewHandler.openView("forside");
      }
    }
  catch (IOException e){

  }
  }
*/
}
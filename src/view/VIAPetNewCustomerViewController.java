package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import model.PetShopModel;

public class VIAPetNewCustomerViewController
{
  @FXML TextField firstNameField;
  @FXML TextField lastNameField;
  @FXML TextField emailField;
  @FXML TextField phoneNumberField;
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
  }

  public void reset()
  {
    firstNameField.setText("");
    lastNameField.setText("");
    emailField.setText("");
    phoneNumberField.setText("");

  }

  @FXML private void CreateButton()
  {
    try
    {

      petShopModel.addCustomer(firstNameField.getText(),
          phoneNumberField.getText(), emailField.getText());
      viewHandler.openView("CustomerList");
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
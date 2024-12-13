package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import model.PetShopModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

      petShopModel.addCustomer(firstNameField.getText(),lastNameField.getText(),
          emailField.getText(),phoneNumberField.getText());
      viewHandler.openView("forside");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e);
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
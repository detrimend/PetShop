package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
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

  @FXML
  private void CreateButton(){
    boolean OpenNewTab = true;

    try{
      petShopModel.addCustomer(
              firstNameField.getText(),
              lastNameField.getText(),
              emailField.getText(),
              phoneNumberField.getText()
      );

      if(OpenNewTab){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VIAPetNewCustomer.fxml));
        Region root = fxmlLoader.load();
        VIAPetNewCustomerViewController controller = fxmlLoader.getController();
        controller.init(viewHandler, petShopModel, root);

        Stage newStage = new Stage();
        newStage.setTitle("Add Customer");
        newStage
      }
    }
  }













/*  @FXML private void CreateButton()
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
  }*/

  @FXML
  private void BackButton() {
    try {
      viewHandler.openView("forside");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
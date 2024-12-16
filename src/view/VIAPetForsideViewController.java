package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.PetShopModel;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Controller class for the VIAPetForside view.
 * It handles the interaction between the view and the model for the main menu.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class VIAPetForsideViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  /**
   * Initializes the controller with the specified view handler, model, and root region.
   *
   * @param viewHandler  the view handler
   * @param petShopModel the pet shop model
   * @param root         the root region
   */
  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
  }

  /**
   * Opens the Sale view.
   */
  @FXML private void SaleButton()
  {
    try
    {
      viewHandler.openView("Sale");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Opens the Care view.
   */
  @FXML private void CareButton()
  {
    try
    {
      viewHandler.openView("Care");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Opens the New Customer view.
   */
  @FXML private void NewCustomerButton()
  {
    try
    {
      viewHandler.openView("NewCustomer");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Opens the Customer List view.
   */
  @FXML private void CustomerListButton()
  {
    try
    {
      viewHandler.openView("CustomerList");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Opens the Animal List view.
   */
  @FXML private void AnimalListButton()
  {
    try
    {
      viewHandler.openView("AnimalList");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Opens the Add Animal view.
   */
  @FXML private void AnimalForSaleButton()
  {
    try
    {
      viewHandler.openView("AddAnimal");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @FXML
  private ImageView imView;

  @FXML
  public void initialize() {
    imView.setImage(new Image(getClass().getResourceAsStream("/resources/Logo2.png")));
  }
}
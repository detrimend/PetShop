package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.AnimalForSale;
import model.PetShopModel;

/**
 * Controller class for the Animal List view.
 * It handles the user interactions and updates the view accordingly.
 * This class is responsible for displaying the list of animals.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalListViewController
{
  @FXML TableView<AnimalViewModel> animalListTable;
  @FXML TableColumn<AnimalViewModel, String> animalNameColumn;
  @FXML TableColumn<AnimalViewModel, String> animalTypeColumn;
  @FXML TableColumn<AnimalViewModel, String> animalGenderColumn;
  @FXML TableColumn<AnimalViewModel, Number> animalAgeColumn;
  @FXML TableColumn<AnimalViewModel, String> animalExtraInfoColumn;
  @FXML TableColumn<AnimalViewModel, String> animalExtraInfo2Column;
  @FXML TableColumn<AnimalViewModel, String> animalSpeciesColumn;
  @FXML TableColumn<AnimalViewModel, Number> animalPriceColumn;
  @FXML TableColumn<AnimalViewModel, String> animalForSaleColumn;
  private FilteredList<AnimalViewModel> filteredAnimals;
  @FXML private TextField typeSearchField;

  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;
  private AnimalListViewModel viewModel;

  /**
   * Constructs an AnimalListViewController.
   */
  public AnimalListViewController()
  {
  }

  /**
   * Initializes the controller with the specified view handler, model, and root region.
   *
   * @param viewHandler  the view handler to manage view transitions
   * @param petShopModel the model to interact with the data
   * @param root         the root region of the view
   */
  @FXML void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new AnimalListViewModel(petShopModel);

    animalNameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    animalTypeColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTypeProperty());
    animalSpeciesColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSpeciesProperty());
    animalGenderColumn.setCellValueFactory(
        cellData -> cellData.getValue().getGenderProperty());
    animalAgeColumn.setCellValueFactory(
        cellData -> cellData.getValue().getAgeProperty());
    animalExtraInfoColumn.setCellValueFactory(
        cellData -> cellData.getValue().getExtraInfoProperty());
    animalExtraInfo2Column.setCellValueFactory(
        cellData -> cellData.getValue().getExtraInfo2Property());
    animalForSaleColumn.setCellValueFactory(
        cellData -> cellData.getValue().getForSaleProperty());
    animalPriceColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPriceProperty());

    animalListTable.setItems(viewModel.getList());

  }

  /**
   * Resets the view model and updates the table with the latest data.
   */
  public void reset()
  {
    viewModel.update();
    animalListTable.setItems(viewModel.getList());
  }

  /**
   * Returns the root region of the view.
   *
   * @return the root region of the view
   */
  public Region getRoot()
  {
    return root;
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

  /**
   * Handles the action of the search by type field.
   * It filters the list of animals by the type specified in the search field.
   */
  @FXML private void searchByType()
  {
    String searchText = typeSearchField.getText();
    if (searchText == null || searchText.isEmpty())
    {
      filteredAnimals.setPredicate(animal -> true);
    }
    else
    {
      filteredAnimals.setPredicate(
          animal -> animal.getTypeProperty().getValue().toString()
              .contains(searchText));
    }
  }
}
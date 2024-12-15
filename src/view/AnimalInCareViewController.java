package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.PetShopModel;

public class AnimalInCareViewController
{
  @FXML TableView<AnimalViewModel> animalListTable;
  @FXML TableColumn<AnimalViewModel, String> animalNameColumn;
  @FXML TableColumn<AnimalViewModel, String> animalTypeColumn;
  @FXML TableColumn<AnimalViewModel,String > animalGenderColumn;
  @FXML TableColumn<AnimalViewModel,Number > animalAgeColumn;
  @FXML TableColumn<AnimalViewModel,String > animalExtraInfoColumn;
  @FXML TableColumn<AnimalViewModel,String > animalExtraInfo2Column;
  @FXML TableColumn<AnimalViewModel,String> animalSpeciesColumn;


  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;
  private AnimalListViewModel viewModel;

  public AnimalInCareViewController()
  {

  }

  @FXML void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.petShopModel = petShopModel;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new AnimalListViewModel(petShopModel);

    animalNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    animalTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    animalSpeciesColumn.setCellValueFactory(cellData -> cellData.getValue().getSpeciesProperty());
    animalGenderColumn.setCellValueFactory(cellData -> cellData.getValue().getGenderProperty());
    animalAgeColumn.setCellValueFactory(cellData -> cellData.getValue().getAgeProperty());
    animalExtraInfoColumn.setCellValueFactory(cellData -> cellData.getValue().getExtraInfoProperty());
    animalExtraInfo2Column.setCellValueFactory(cellData -> cellData.getValue().getExtraInfo2Property());

    animalListTable.setItems(viewModel.getList());

    reset();

    // til debug: System.out.println("AnimalListViewController initialized");
  }

  public void reset()
  {
    viewModel.update();
    animalListTable.setItems(viewModel.getList());
  }

  public Region getRoot()
  {
    return root;
  }
  @FXML
  private void BackButton() {
    try {
      viewHandler.openView("VIACare");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

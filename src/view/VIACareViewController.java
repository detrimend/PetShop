package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the VIACare view.
 * It handles the user interactions and updates the view accordingly.
 * This class is responsible for managing the care of animals.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class VIACareViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private PetShopModel petShopModel;

  @FXML private TextField numberSearchField;
  @FXML private TableView<CustomerViewModel> customerTable;
  @FXML private TableColumn<CustomerViewModel, String> nameCustomerColumn;
  @FXML private TableColumn<CustomerViewModel, Number> numberColumn;
  @FXML private TableView<AnimalViewModel> animalTable;
  @FXML private TableColumn<AnimalViewModel, String> nameAnimalColumn;
  @FXML private TableColumn<AnimalViewModel, String> speciesColumn;
  @FXML private DatePicker startDatePicker;
  @FXML private TextField daysField;

  private FilteredList<CustomerViewModel> filteredCustomers;
  private CustomerViewModel selectedCustomer;

  /**
   * Initializes the controller with the specified view handler, model, and root region.
   *
   * @param viewHandler  the view handler to manage view transitions
   * @param petShopModel the model to interact with the data
   * @param root         the root region of the view
   */
  public void init(ViewHandler viewHandler, PetShopModel petShopModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.petShopModel = petShopModel;
    this.root = root;

    ObservableList<CustomerViewModel> customers = FXCollections.observableArrayList();
    for (int i = 0; i < petShopModel.getNumberOfCustomers(); i++)
    {
      Customer customer = petShopModel.getCustomerByIndex(i);
      customers.add(new CustomerViewModel(customer));
    }

    filteredCustomers = new FilteredList<>(customers, p -> true);
    customerTable.setItems(filteredCustomers);
    nameCustomerColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    numberColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPhoneNumberProperty());

    customerTable.getSelectionModel().selectedItemProperty()
        .addListener((obs, oldVal, newVal) -> {
          selectedCustomer = newVal;
          loadAnimalsForCustomer(newVal);
        });

    nameAnimalColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNameProperty());
    speciesColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSpeciesProperty());
    animalTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

  }

  /**
   * Loads the animals owned by the specified customer.
   *
   * @param customerViewModel the customer view model to load animals for
   */
  private void loadAnimalsForCustomer(CustomerViewModel customerViewModel)
  {
    if (customerViewModel != null)
    {
      Customer customer = petShopModel.getCustomer(
          customerViewModel.getPhoneNumberProperty().get());
      OwnedAnimalsList animals = petShopModel.getAnimalsByCustomer(customer);

      ObservableList<AnimalViewModel> animalList = FXCollections.observableArrayList();
      for (int i = 0; i < animals.getAmountOfAnimals(); i++)
      {
        animalList.add(new AnimalViewModel(animals.getAnimalByIndex(i)));
      }
      animalTable.setItems(animalList);
    }
  }

  /**
   * Searches for customers by name.
   */
  @FXML private void searchByPhoneNumber()
  {
    String searchText = numberSearchField.getText();
    if (searchText == null || searchText.isEmpty())
    {
      filteredCustomers.setPredicate(customer -> true);
    }
    else
    {
      filteredCustomers.setPredicate(
          customer -> customer.getPhoneNumberProperty().getValue().toString()
              .contains(searchText));
    }
  }

  /**
   * Handles the action of the assign button.
   * It creates a new reservation for the selected customer and animals.
   */
  @FXML private void handleAssign()
  {
    if (selectedCustomer == null)
    {
      showAlert(Alert.AlertType.ERROR, "No Customer Selected",
          "Please select a customer.");
      return;
    }

    if (startDatePicker.getValue() == null || daysField.getText().isEmpty())
    {
      showAlert(Alert.AlertType.ERROR, "Invalid Input",
          "Please select a start date and enter a valid number of days.");
      return;
    }

    try
    {
      LocalDate startDate = startDatePicker.getValue();
      int days = Integer.parseInt(daysField.getText());

      List<OwnedAnimal> selectedAnimals = new ArrayList<>();
      for (int i = 0; i < petShopModel.getAmountOfAnimals(); i++)
      {
        OwnedAnimal selectedAnimal = petShopModel.getAnimalByIndex(i);
        if (selectedAnimal.getName().equals(
            animalTable.getSelectionModel().getSelectedItem().getNameProperty())
            || selectedAnimal.getOwner().getPhoneNumber()
            == (selectedCustomer.getPhoneNumberProperty().get()))
        {
          selectedAnimals.add(petShopModel.getAnimalByIndex(i));
        }
      }

      if (selectedAnimals.isEmpty())
      {
        showAlert(Alert.AlertType.ERROR, "No Animal Selected",
            "Please select one or more animals.");
        return;
      }

      DateInterval interval = new DateInterval(startDate, days);
      OwnedAnimalsList animalList = new OwnedAnimalsList();

      for (int i = 0; i < selectedAnimals.size(); i++)
      {
        selectedAnimals.get(i).putInCare();
        animalList.addAnimal(selectedAnimals.get(i));
      }

      Customer customer = petShopModel.getCustomer(
          selectedCustomer.getPhoneNumberProperty().get());

      boolean success = petShopModel.addReservation(interval, customer,
          animalList);
      if (success)
      {
        showAlert(Alert.AlertType.INFORMATION, "Reservation Created",
            "The reservation was successfully created!");
      }
      else
      {
        showAlert(Alert.AlertType.ERROR, "Error",
            "Failed to create reservation.");
      }
    }
    catch (Exception e)
    {
      showAlert(Alert.AlertType.ERROR, "Error",
          "An error occurred: " + e.getMessage());
    }
  }

  /**
   * Shows an alert with the specified type, title, and content.
   *
   * @param type    the type of the alert
   * @param title   the title of the alert
   * @param content the content of the alert
   */
  private void showAlert(Alert.AlertType type, String title, String content)
  {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setContentText(content);
    alert.showAndWait();
  }

  /**
   * Handles the action of the back button.
   * It opens the main menu view.
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
   * Handles the action of the animals in care button.
   * It opens the care list view.
   */
  @FXML private void AnimalsInCareButton()
  {
    try
    {
      viewHandler.openView("CareList");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
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
}
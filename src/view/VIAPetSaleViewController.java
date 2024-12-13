package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Customer;
import model.Person;
import model.PetShopModel;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class VIAPetSaleViewController {
    private Region root;
    private ViewHandler viewHandler;
    private PetShopModel petShopModel;

    public void init(ViewHandler viewHandler, PetShopModel petShopModel, Region root) {
        this.petShopModel = petShopModel;
        this.viewHandler = viewHandler;
        this.root = root;
    }

    @FXML
       private void addCustomerButton() {
           /* viewHandler.openView("NewCustomer");*/ //Snakket med Steffen, kan bruge boolean til at ændres til at åbne nyt window(if - else) før og efter FXMLLOader
       try

    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VIAPetNewCustomer.fxml")); // vælg path
        Region root = fxmlLoader.load();
        VIAPetNewCustomerViewController controller = fxmlLoader.getController();
        controller.init(viewHandler, petShopModel, root);

        Stage newStage = new Stage();
        newStage.setTitle("Add Customer");  //set titlen
        newStage.setScene(new Scene(root));
        newStage.show();
    } catch(IOException e)

    {
        e.printStackTrace();
    }
}


        @FXML
        private void RefreshButton() {
            try {
                viewHandler.openView("Sale");
            } catch (Exception e) {
                e.printStackTrace();
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

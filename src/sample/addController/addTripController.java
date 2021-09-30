package sample.addController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.BD.DatabaseHandler;
import sample.LoggingMain;

import java.util.logging.Level;
import java.util.logging.Logger;

public class addTripController {

    @FXML
    private TextField codeTrip;

    @FXML
    private TextField numberCar;

    @FXML
    private TextField codeDriver;

    @FXML
    private Button add;

    @FXML
    private TextField dateTrip;

    @FXML
    private TextField travelTime;

    @FXML
    private TextField cost;

    @FXML
    private TextField description;


    public void add(javafx.event.ActionEvent actionEvent) {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addTrip(codeTrip.getText(),numberCar.getText(),codeDriver.getText(),dateTrip.getText(),travelTime.getText(),cost.getText(),description.getText());
    }
}



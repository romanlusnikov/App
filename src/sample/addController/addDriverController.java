package sample.addController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.BD.DatabaseHandler;

public class addDriverController {

    @FXML
    private TextField codeDriver;

    @FXML
    private TextField number;

    @FXML
    private TextField fullName;

    @FXML
    private Button add;

    public void add(javafx.event.ActionEvent actionEvent) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addDriver(codeDriver.getText(),fullName.getText(),number.getText());
    }
}

package sample.addController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.BD.DatabaseHandler;

public class addCarController {

    @FXML
    private TextField codeCar;

    @FXML
    private TextField color;

    @FXML
    private TextField stampCar;

    @FXML
    private TextField numberCar;

    @FXML
    private Button add;

    public void add(javafx.event.ActionEvent actionEvent) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addCar(codeCar.getText(),numberCar.getText(),stampCar.getText(),color.getText());
    }
}
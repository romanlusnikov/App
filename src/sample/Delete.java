package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.BD.DatabaseHandler;


public class Delete {

    @FXML
    private TextField textFieldDelete;

    @FXML
    private Button deleteButton;

    @FXML
    private Text error;


    public void delete(ActionEvent actionEvent) {
        if (textFieldDelete.getText().isEmpty() || textFieldDelete.getText().matches("\\d")) {
            error.setVisible(true);
        } else {
            DatabaseHandler databaseHandler = new DatabaseHandler();
        }
    }
}

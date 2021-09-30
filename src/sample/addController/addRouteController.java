package sample.addController;

import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
import sample.BD.DatabaseHandler;

public class addRouteController {

    @FXML
    private TextField codeRoute;

    @FXML
    private TextField length;

    @FXML
    private TextField name;

    @FXML
    private Button add;


    public void add(javafx.event.ActionEvent actionEvent) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addRoute(codeRoute.getText(),name.getText(),length.getText());
    }
}

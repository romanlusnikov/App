package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.BD.DatabaseHandler;
import sample.designer.CarDesigner;
import sample.designer.DriverDesigner;
import sample.designer.RouteDesigner;
import sample.designer.TripDesigner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private TableView<CarDesigner> tableViewCar;

    @FXML
    private TableColumn<CarDesigner, Integer> codeCarColumn;

    @FXML
    private TableColumn<CarDesigner, String> numberCarColumn;

    @FXML
    private TableColumn<CarDesigner, String> stampСarColumn;

    @FXML
    private TableColumn<CarDesigner, String> colorCarColumn;

    @FXML
    private Button addCar;

    @FXML
    private Button deleteCar;

    @FXML
    private TableView<DriverDesigner> TableViewDriver;

    @FXML
    private TableColumn<DriverDesigner, Integer> codeDriverColumn;

    @FXML
    private TableColumn<DriverDesigner, String> fullNameDriverColumn;

    @FXML
    private TableColumn<DriverDesigner, String> numberDriverColumn;

    @FXML
    private Button addDriver;

    @FXML
    private Button deleteDriver;

    @FXML
    private TableView<RouteDesigner> TableViewRoute;

    @FXML
    private TableColumn<RouteDesigner, Integer> codeRouteColumn;

    @FXML
    private TableColumn<RouteDesigner, String> nameRouteColumn;

    @FXML
    private TableColumn<RouteDesigner, String> lengthRouteColumn;

    @FXML
    private Button addRoute;

    @FXML
    private Button deleteRoute;

    @FXML
    private TableView<TripDesigner> TableViewTrip;

    @FXML
    private TableColumn<TripDesigner, Integer> codeTripColumn;

    @FXML
    private TableColumn<TripDesigner, String> codeCarTripColumn;

    @FXML
    private TableColumn<TripDesigner, String> codeDriverTripColumn;

    @FXML
    private TableColumn<TripDesigner, String> codeRouteTripColumn;

    @FXML
    private TableColumn<TripDesigner, String> dateTripColumn;

    @FXML
    private TableColumn<TripDesigner, String> travelTimeColumn;

    @FXML
    private TableColumn<TripDesigner, String> costColumn;

    @FXML
    private TableColumn<TripDesigner, String> descriptionColumn;

    @FXML
    private Button addTrip;

    @FXML
    private Button deleteTrip;

    private static Logger logger;

    static {
        try (FileInputStream configFile = new FileInputStream("src\\Sample\\logging.config")) {
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(LoggingMain.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }



    private ObservableList<CarDesigner> DBCar = FXCollections.observableArrayList();
    private ObservableList<DriverDesigner> DBDriver = FXCollections.observableArrayList();
    private ObservableList<RouteDesigner> DBRoute = FXCollections.observableArrayList();
    private ObservableList<TripDesigner> DBTrip = FXCollections.observableArrayList();

    public void addCar(ActionEvent actionEvent) {
        addCar.getScene().getWindow().hide();
        window("/sample/fxml/addCar.fxml");
        logger.log(Level.INFO, "Добавление авто...");
    }


    public void addDriver(ActionEvent actionEvent) {
        addDriver.getScene().getWindow().hide();
        window("/sample/fxml/addDriver.fxml");
        logger.log(Level.INFO, "Добавление водителя...");
    }

    public void addRoute(ActionEvent actionEvent) {
        addRoute.getScene().getWindow().hide();
        window("/sample/fxml/addRoute.fxml");
        logger.log(Level.INFO, "Добавление маршрута...");
    }

    public void addTrip(ActionEvent actionEvent) {
        addTrip.getScene().getWindow().hide();
        window("/sample/fxml/addTrip.fxml");
        logger.log(Level.INFO, "Добавление рейса...");
    }

    public void window(String put) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(put));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void deleteTrip(ActionEvent actionEvent) {
        deleteTrip.getScene().getWindow().hide();
        window("/sample/fxml/delete.fxml");
        logger.log(Level.INFO, "Удаление рейса");
    }

    public void deleteRoute(ActionEvent actionEvent) {
        deleteRoute.getScene().getWindow().hide();
        window("/sample/fxml/delete.fxml");
        logger.log(Level.INFO, "Удаление маршрута");
    }

    public void deleteDriver(ActionEvent actionEvent) {
        deleteDriver.getScene().getWindow().hide();
        window("/sample/fxml/delete.fxml");
        logger.log(Level.INFO, "Удаление водителя");
    }

    public void deleteCar(ActionEvent actionEvent) {
        deleteCar.getScene().getWindow().hide();
        window("/sample/fxml/delete.fxml");
        logger.log(Level.INFO, "Удаление машины");
    }

    public void carsTable(Event event) {
        codeCarColumn.setCellValueFactory(new PropertyValueFactory<>("codeCar"));
        numberCarColumn.setCellValueFactory(new PropertyValueFactory<>("numberCar"));
        stampСarColumn.setCellValueFactory(new PropertyValueFactory<>("stamp"));
        colorCarColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        DatabaseHandler DBHandler = new DatabaseHandler();
        DBCar = DBHandler.getCars();
        tableViewCar.setItems(DBCar);
        logger.log(Level.INFO, "Получение таблицы автомобилей с БД");
    }

    public void driversTable(Event event) {
        codeDriverColumn.setCellValueFactory(new PropertyValueFactory<>("codeDriver"));
        fullNameDriverColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        numberDriverColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        DatabaseHandler DBHandler = new DatabaseHandler();
        DBDriver = DBHandler.getDriver();
        TableViewDriver.setItems(DBDriver);
        logger.log(Level.INFO, "Получение таблицы водителей с БД");
    }

    public void routeTable(Event event) {
        codeRouteColumn.setCellValueFactory(new PropertyValueFactory<>("codeRoute"));
        nameRouteColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lengthRouteColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        DatabaseHandler DBHandler = new DatabaseHandler();
        DBRoute = DBHandler.getRoute();
        TableViewRoute.setItems(DBRoute);
        logger.log(Level.INFO, "Получение таблицы маршрутов с БД");
    }

    public void tripTable(Event event) {
        codeTripColumn.setCellValueFactory(new PropertyValueFactory<>("codeTrip"));
        codeCarTripColumn.setCellValueFactory(new PropertyValueFactory<>("codeCar"));
        codeDriverTripColumn.setCellValueFactory(new PropertyValueFactory<>("codeDriver"));
        codeRouteTripColumn.setCellValueFactory(new PropertyValueFactory<>("codeRoute"));
        dateTripColumn.setCellValueFactory(new PropertyValueFactory<>("dateTrip"));
        travelTimeColumn.setCellValueFactory(new PropertyValueFactory<>("travelTime"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        DatabaseHandler DBHandler = new DatabaseHandler();
        DBTrip = DBHandler.getTrip();
        TableViewTrip.setItems(DBTrip);
        logger.log(Level.INFO, "Получение таблицы рейсов с БД");
    }
}

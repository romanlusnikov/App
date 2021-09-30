package sample.BD;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.designer.CarDesigner;
import sample.designer.DriverDesigner;
import sample.designer.RouteDesigner;
import sample.designer.TripDesigner;

import java.sql.*;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection(String dbName) throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void addCar(String codeCar, String numberCar, String stamp, String color) {
        String insert = "INSERT INTO " + Const.CARS_TABLE + "(" + Const.CODE_CARS + ", " + Const.NUMBER_CARS + ", "
                + Const.STAMP + ", " + Const.COLOR + ") " + "VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection(dbName).prepareStatement(insert);

            prSt.setString(1, codeCar);
            prSt.setString(2, numberCar);
            prSt.setString(3, stamp);
            prSt.setString(4, color);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDriver(String codeDriver, String fullName, String number) {
        String insert = "INSERT INTO " + Const.DRIVERS_TABLE + "(" + Const.CODE_DRIVERS + ", " + Const.FULL_NAME + ", "
                + Const.NUMBER + ") " + "VALUES(?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection(dbName).prepareStatement(insert);

            prSt.setString(1, codeDriver);
            prSt.setString(2, fullName);
            prSt.setString(3, number);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addRoute(String codeRoute, String name, String length) {
        String insert = "INSERT INTO " + Const.ROUTS_TABLE + "(" + Const.CODE_ROUTE + ", " + Const.NAME + ", "
                + Const.LENGTH + ") " + "VALUES(?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection(dbName).prepareStatement(insert);

            prSt.setString(1, codeRoute);
            prSt.setString(2, name);
            prSt.setString(3, length);


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addTrip(String codeTrip, String codeCar, String codeDriver, String dateTrip, String travelTime, String cost, String description) {
        String insert = "INSERT INTO " + Const.TRIPS_TABLE + "(" + Const.CODE_TRIP + ", " + Const.CODE_CAR + ", "
                + Const.CODE_DRIVER + ", " + Const.DATE_TRIP + ", " + Const.TRAVEL_TIME + ", " + Const.COST + ", " + Const.DESCRIPTION + ") " + "VALUES(?, ?, ?, ?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection(dbName).prepareStatement(insert);

            prSt.setString(1, codeTrip);
            prSt.setString(2, codeCar);
            prSt.setString(3, codeDriver);
            prSt.setString(4, dateTrip);
            prSt.setString(5, travelTime);
            prSt.setString(6, cost);
            prSt.setString(7, description);


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<CarDesigner> getCars(){
        try {
            Connection connection = getDbConnection(dbName);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM virage.cars;");
            ResultSet result = statement.executeQuery();
            ObservableList<CarDesigner> list= FXCollections.observableArrayList();
            while (result.next()){
                CarDesigner carDesigner = new CarDesigner();
                carDesigner.setCodeCar(result.getInt("codeCar"));
                carDesigner.setNumberCar(result.getString("numberCar"));
                carDesigner.setStamp(result.getString("stamp"));
                carDesigner.setColor(result.getString("color"));
                list.add(carDesigner);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<DriverDesigner> getDriver(){
        try {
            Connection connection = getDbConnection(dbName);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM virage.drivers;");
            ResultSet result = statement.executeQuery();
            ObservableList<DriverDesigner> list= FXCollections.observableArrayList();
            while (result.next()){
                DriverDesigner driverDesigner = new DriverDesigner();
                driverDesigner.setCodeDriver(result.getInt("codeDriver"));
                driverDesigner.setFullName(result.getString("fullName"));
                driverDesigner.setNumber(result.getString("number"));
                list.add(driverDesigner);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<RouteDesigner> getRoute(){
        try {
            Connection connection = getDbConnection(dbName);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM virage.route;");
            ResultSet result = statement.executeQuery();
            ObservableList<RouteDesigner> list= FXCollections.observableArrayList();
            while (result.next()){
                RouteDesigner routeDesigner = new RouteDesigner();
                routeDesigner.setCodeRoute(result.getInt("codeRoute"));
                routeDesigner.setName(result.getString("name"));
                routeDesigner.setLength(result.getString("length"));
                list.add(routeDesigner);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<TripDesigner> getTrip(){
        try {
            Connection connection = getDbConnection(dbName);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM virage.trips;");
            ResultSet result = statement.executeQuery();
            ObservableList<TripDesigner> list= FXCollections.observableArrayList();
            while (result.next()){
                TripDesigner tripDesigner = new TripDesigner();
                tripDesigner.setCodeTrip(result.getInt("codeTrip"));
                tripDesigner.setCodeCar(result.getString("codeCar"));
                tripDesigner.setCodeDriver(result.getString("codeDriver"));
                tripDesigner.setCodeRoute(result.getString("codeRoute"));
                tripDesigner.setDateTrip(result.getString("dateTrip"));
                tripDesigner.setTravelTime(result.getString("travelTime"));
                tripDesigner.setCost(result.getString("cost"));
                tripDesigner.setDescription(result.getString("description"));
                list.add(tripDesigner);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

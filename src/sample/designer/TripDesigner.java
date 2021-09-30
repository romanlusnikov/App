package sample.designer;

public class TripDesigner {
    public int getCodeTrip() {
        return codeTrip;
    }

    public void setCodeTrip(int codeTrip) {
        this.codeTrip = codeTrip;
    }

    public String getCodeCar() {
        return codeCar;
    }

    public void setCodeCar(String codeCar) {
        this.codeCar = codeCar;
    }

    public String getCodeDriver() {
        return codeDriver;
    }

    public void setCodeDriver(String codeDriver) {
        this.codeDriver = codeDriver;
    }

    public String getDateTrip() {
        return dateTrip;
    }

    public void setDateTrip(String dateTrip) {
        this.dateTrip = dateTrip;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCodeRoute() {
        return codeRoute;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    private int codeTrip;
    private String codeCar;
    private String codeDriver;
    private String codeRoute;
    private String dateTrip;
    private String travelTime;
    private String cost;
    private String description;
}

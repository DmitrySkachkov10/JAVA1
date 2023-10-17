package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto;

public class Airport {
    private String id;
    private String airportName;
    private String city;
    private String coordinates;
    private String timeZone;

    public Airport(String airportName, String city, String coordinates, String timeZone) {
        this.airportName = airportName;
        this.city = city;
        this.coordinates = coordinates;
        this.timeZone = timeZone;
    }

    public Airport() {
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

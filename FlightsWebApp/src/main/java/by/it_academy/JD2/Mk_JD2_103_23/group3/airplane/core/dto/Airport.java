package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto;

public class Airport {
    private String airport_code;
    private String airportName;
    private String city;
    private String coordinates;
    private String timeZone;

    public Airport(String airport_code, String airportName, String city, String coordinates, String timeZone) {
        this.airport_code = airport_code;
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

    public String getAirport_code() {
        return airport_code;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }
}

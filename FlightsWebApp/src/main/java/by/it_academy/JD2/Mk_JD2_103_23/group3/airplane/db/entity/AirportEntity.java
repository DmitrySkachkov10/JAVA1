package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity;

import java.util.Objects;

public class AirportEntity {
    private String id;
    private String airportName;
    private String city;
    private String coordinates;
    private String timeZone;

    public AirportEntity(String airportName, String city, String coordinates, String timeZone) {
        this.airportName = airportName;
        this.city = city;
        this.coordinates = coordinates;
        this.timeZone = timeZone;
    }

    public AirportEntity() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportEntity)) return false;
        AirportEntity that = (AirportEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(airportName, that.airportName) && Objects.equals(city, that.city) && Objects.equals(coordinates, that.coordinates) && Objects.equals(timeZone, that.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportName, city, coordinates, timeZone);
    }

    @Override
    public String toString() {
        return "AirportEntity{" +
                "id='" + id + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}

package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(schema = "bookings", name = "airports_data")
public class AirportEntity {


    @Id
    @Column(name = "airport_code")
    private String airportCode;
    @Column(name = "airport_name")
    private String airportName;
    private String city;

    private String coordinates;

    private String timezone;

    public AirportEntity(String airportCode, String airportName, String city, String coordinates, String timezone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public AirportEntity() {
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportEntity)) return false;
        AirportEntity that = (AirportEntity) o;
        return Objects.equals(airportCode, that.airportCode) && Objects.equals(airportName, that.airportName) && Objects.equals(city, that.city) && Objects.equals(coordinates, that.coordinates) && Objects.equals(timezone, that.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportCode, airportName, city, coordinates, timezone);
    }

    @Override
    public String toString() {
        return "AirportEntity{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}

package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity;

import java.util.Objects;
import java.util.TimeZone;

public class FlightEntity {
    private String flightId;
    private String flightNo;
    private String scheduledDeparture;
    private String scheduledDepartureLocal;
    private String scheduledArrival;
    private String scheduledArrivalLocal;
    private String scheduledDuration;
    private String departureAirport;
    private String departureAirportName;
    private String departureCity;
    private String arrivalAirport;
    private String arrivalAirportName;
    private String arrivalCity;
    private String status;
    private String aircraftCode;
    private String actualDeparture;
    private String actualDepartureLocal;
    private String actualArrival;
    private String actualArrivalLocal;
    private String actualDuration;

    public FlightEntity() {
    }

    public FlightEntity(String flightId, String flightNo, String scheduledDeparture, String scheduledDepartureLocal, String scheduledArrival, String scheduledArrivalLocal, String scheduledDuration, String departureAirport, String departureAirportName, String departureCity, String arrivalAirport, String arrivalAirportName, String arrivalCity, String status, String aircraftCode, String actualDeparture, String actualDepartureLocal, String actualArrival, String actualArrivalLocal, String actualDuration) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledDepartureLocal = scheduledDepartureLocal;
        this.scheduledArrival = scheduledArrival;
        this.scheduledArrivalLocal = scheduledArrivalLocal;
        this.scheduledDuration = scheduledDuration;
        this.departureAirport = departureAirport;
        this.departureAirportName = departureAirportName;
        this.departureCity = departureCity;
        this.arrivalAirport = arrivalAirport;
        this.arrivalAirportName = arrivalAirportName;
        this.arrivalCity = arrivalCity;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualDepartureLocal = actualDepartureLocal;
        this.actualArrival = actualArrival;
        this.actualArrivalLocal = actualArrivalLocal;
        this.actualDuration = actualDuration;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(String scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public String getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public void setScheduledDepartureLocal(String scheduledDepartureLocal) {
        this.scheduledDepartureLocal = scheduledDepartureLocal;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getScheduledArrivalLocal() {
        return scheduledArrivalLocal;
    }

    public void setScheduledArrivalLocal(String scheduledArrivalLocal) {
        this.scheduledArrivalLocal = scheduledArrivalLocal;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public void setScheduledDuration(String scheduledDuration) {
        this.scheduledDuration = scheduledDuration;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public String getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public void setActualDepartureLocal(String actualDepartureLocal) {
        this.actualDepartureLocal = actualDepartureLocal;
    }

    public String getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(String actualArrival) {
        this.actualArrival = actualArrival;
    }

    public String getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    public void setActualArrivalLocal(String actualArrivalLocal) {
        this.actualArrivalLocal = actualArrivalLocal;
    }

    public String getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(String actualDuration) {
        this.actualDuration = actualDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightEntity)) return false;
        FlightEntity that = (FlightEntity) o;
        return Objects.equals(flightId, that.flightId) && Objects.equals(flightNo, that.flightNo) && Objects.equals(scheduledDeparture, that.scheduledDeparture) && Objects.equals(scheduledDepartureLocal, that.scheduledDepartureLocal) && Objects.equals(scheduledArrival, that.scheduledArrival) && Objects.equals(scheduledArrivalLocal, that.scheduledArrivalLocal) && Objects.equals(scheduledDuration, that.scheduledDuration) && Objects.equals(departureAirport, that.departureAirport) && Objects.equals(departureAirportName, that.departureAirportName) && Objects.equals(departureCity, that.departureCity) && Objects.equals(arrivalAirport, that.arrivalAirport) && Objects.equals(arrivalAirportName, that.arrivalAirportName) && Objects.equals(arrivalCity, that.arrivalCity) && Objects.equals(status, that.status) && Objects.equals(aircraftCode, that.aircraftCode) && Objects.equals(actualDeparture, that.actualDeparture) && Objects.equals(actualDepartureLocal, that.actualDepartureLocal) && Objects.equals(actualArrival, that.actualArrival) && Objects.equals(actualArrivalLocal, that.actualArrivalLocal) && Objects.equals(actualDuration, that.actualDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNo, scheduledDeparture, scheduledDepartureLocal, scheduledArrival, scheduledArrivalLocal, scheduledDuration, departureAirport, departureAirportName, departureCity, arrivalAirport, arrivalAirportName, arrivalCity, status, aircraftCode, actualDeparture, actualDepartureLocal, actualArrival, actualArrivalLocal, actualDuration);
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "flightId='" + flightId + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", scheduledDeparture='" + scheduledDeparture + '\'' +
                ", scheduledDepartureLocal='" + scheduledDepartureLocal + '\'' +
                ", scheduledArrival='" + scheduledArrival + '\'' +
                ", scheduledArrivalLocal='" + scheduledArrivalLocal + '\'' +
                ", scheduledDuration='" + scheduledDuration + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDeparture='" + actualDeparture + '\'' +
                ", actualDepartureLocal='" + actualDepartureLocal + '\'' +
                ", actualArrival='" + actualArrival + '\'' +
                ", actualArrivalLocal='" + actualArrivalLocal + '\'' +
                ", actualDuration='" + actualDuration + '\'' +
                '}';
    }
}

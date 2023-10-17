package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto;

import java.time.LocalDate;
import java.util.Objects;

public class FlightFilter {
    private LocalDate scheduledDeparture;
    private LocalDate scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;
    private String status;

    public FlightFilter() {
    }

    public FlightFilter(LocalDate scheduledDeparture, LocalDate scheduledArrival, String departureAirport, String arrivalAirport, String status) {
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
    }

    public LocalDate getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDate scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDate getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDate scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightFilter that = (FlightFilter) o;

        if (!Objects.equals(scheduledDeparture, that.scheduledDeparture))
            return false;
        if (!Objects.equals(scheduledArrival, that.scheduledArrival))
            return false;
        if (!Objects.equals(departureAirport, that.departureAirport))
            return false;
        if (!Objects.equals(arrivalAirport, that.arrivalAirport))
            return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = scheduledDeparture != null ? scheduledDeparture.hashCode() : 0;
        result = 31 * result + (scheduledArrival != null ? scheduledArrival.hashCode() : 0);
        result = 31 * result + (departureAirport != null ? departureAirport.hashCode() : 0);
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightFilter{" +
                "scheduledDeparture=" + scheduledDeparture +
                ", scheduledArrival=" + scheduledArrival +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

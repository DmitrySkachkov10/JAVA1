package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(schema = "bookings", name = "aircrafts_data")
public class AirCraft {

    @Id
    private String aircraft_code;
    private String model;
    private int range;

    public AirCraft(String aircraft_code, String model, int range) {
        this.aircraft_code = aircraft_code;
        this.model = model;
        this.range = range;
    }

    public AirCraft(){

    }

    public String getAircraft_code() {
        return aircraft_code;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCraft airCraft = (AirCraft) o;
        return range == airCraft.range && Objects.equals(aircraft_code, airCraft.aircraft_code) && Objects.equals(model, airCraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraft_code, model, range);
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "aircraft_code='" + aircraft_code + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}

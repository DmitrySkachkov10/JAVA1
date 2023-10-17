package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity;

import java.util.Objects;

public class AirCraftEntity {
    private String aircraft_code;
    private String model;
    private int range;


    public AirCraftEntity() {
    }

    public AirCraftEntity(String aircraft_code, String model, int range) {
        this.aircraft_code = aircraft_code;
        this.model = model;
        this.range = range;
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
        if (!(o instanceof AirCraftEntity)) return false;
        AirCraftEntity that = (AirCraftEntity) o;
        return range == that.range && Objects.equals(aircraft_code, that.aircraft_code) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraft_code, model, range);
    }

    @Override
    public String toString() {
        return "AirCraftEntity{" +
                "aircraft_code='" + aircraft_code + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}

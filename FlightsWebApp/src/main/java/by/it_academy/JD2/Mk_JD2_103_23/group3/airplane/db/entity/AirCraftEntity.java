package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(schema = "bookings", name = "aircrafts_data")
public class AirCraftEntity {

    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;
    private String model;
    private int range;


    public AirCraftEntity() {
    }

    public AirCraftEntity(String aircraftCode, String model, int range) {
        this.aircraftCode = aircraftCode;
        this.model = model;
        this.range = range;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
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
        return range == that.range && Objects.equals(aircraftCode, that.aircraftCode) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftCode, model, range);
    }

    @Override
    public String toString() {
        return "AirCraftEntity{" +
                "aircraft_code='" + aircraftCode + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}

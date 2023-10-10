package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto;

public class AirCraftDTO {
    private String aircraft_code;
    private String model;
    private int range;

    public AirCraftDTO(String aircraft_code, String model, int range) {
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
}

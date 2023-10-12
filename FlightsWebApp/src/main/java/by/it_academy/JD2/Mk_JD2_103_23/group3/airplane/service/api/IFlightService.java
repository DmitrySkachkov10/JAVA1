package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;


import java.util.List;

public interface IFlightService {
    List<Flight> getFlights();
    List<Flight> getFlights(int page, int size, List<String> filters);
    List<Flight> getFlights(int page, int size);
}

package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;

import java.util.List;


public class FlightService implements IFlightService {
    IFlightDao flightDao;

    public FlightService(IFlightDao instance) {
        this.flightDao = instance;
    }


    @Override
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }

    @Override
    public List<Flight> getFlights(int page, int size, List<String> filters) {
        return flightDao.getFlights(page, size, filters);
    }

    @Override
    public List<Flight> getFlights(int page, int size) {
        return flightDao.getFlights(page, size);
    }
}

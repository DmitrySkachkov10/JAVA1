package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.Flight;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageSize;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;

import java.util.List;
import java.util.stream.Collectors;


public class FlightService implements IFlightService {
    IFlightDao flightDao;

    public FlightService(IFlightDao instance) {
        this.flightDao = instance;
    }



    @Override
    public List<Flight> getFlights(FlightFilter filter, PageSize pageSize) {
        return flightDao.getFlights(filter, pageSize).stream().map(
                flightEntity -> new Flight(flightEntity.getFlightId(), flightEntity.getFlightNo(),
                        flightEntity.getScheduledDeparture(), flightEntity.getScheduledDepartureLocal(),
                        flightEntity.getScheduledArrival(), flightEntity.getScheduledArrivalLocal(),
                        flightEntity.getScheduledDuration(), flightEntity.getDepartureAirport(),
                        flightEntity.getDepartureAirportName(), flightEntity.getDepartureCity(),
                        flightEntity.getArrivalAirport(), flightEntity.getArrivalAirportName(),
                        flightEntity.getArrivalCity(), flightEntity.getStatus(),
                        flightEntity.getAircraftCode(), flightEntity.getActualDeparture(),
                        flightEntity.getActualDepartureLocal(), flightEntity.getActualArrival(),
                        flightEntity.getActualArrivalLocal(), flightEntity.getActualDuration())).collect(Collectors.toList());
    }
}

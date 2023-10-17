package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.Airport;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;


import java.util.List;
import java.util.stream.Collectors;

public class AirportService implements IAirportService {
    private IAirportDao airportDao;
    public AirportService(IAirportDao instance) {
        this.airportDao = instance;
    }

    @Override
    public List<Airport> getAirports() {
        return airportDao.getAirports().stream()
                .map(airportEntity -> new Airport(airportEntity.getAirportCode(), airportEntity.getAirportName(),
                        airportEntity.getCity(), airportEntity.getCoordinates(),
                        airportEntity.getTimezone())).collect(Collectors.toList());
    }
}

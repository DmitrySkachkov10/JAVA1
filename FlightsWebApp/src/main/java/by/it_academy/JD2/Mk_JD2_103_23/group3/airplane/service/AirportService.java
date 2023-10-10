package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Airport;


import java.util.List;

public class AirportService implements IAirportService {
    IAirportDao airportDao;
    public AirportService(IAirportDao instance) {
        this.airportDao = instance;
    }

    @Override
    public List<Airport> getAirports() {
        return airportDao.getAirports();
    }
}

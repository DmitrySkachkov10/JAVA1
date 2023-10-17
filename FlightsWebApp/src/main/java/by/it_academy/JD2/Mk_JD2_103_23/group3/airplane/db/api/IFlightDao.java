package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageSize;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;


import java.util.List;

public interface IFlightDao {




    List<Flight> getFlights(FlightFilter filter, PageSize pageSize);


}

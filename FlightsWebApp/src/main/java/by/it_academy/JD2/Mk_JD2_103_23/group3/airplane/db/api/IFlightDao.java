package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageSize;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity.FlightEntity;


import java.util.List;

public interface IFlightDao {




    List<FlightEntity> getFlights(FlightFilter filter, PageSize pageSize);


}

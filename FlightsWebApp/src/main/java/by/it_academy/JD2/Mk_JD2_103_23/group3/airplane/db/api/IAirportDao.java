package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity.AirportEntity;

import java.util.List;

public interface IAirportDao {
    List<AirportEntity> getAirports() ;
}

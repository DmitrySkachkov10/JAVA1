package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Airport;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDao implements IAirportDao {
    private DataSource ds = DataSourceCreator.getInstance();
    Airport airport = new Airport();
    List<Airport> airports = new ArrayList<>();

    public AirportDao() {
    }


    @Override
    public List<Airport> getAirports()  {
        String sql = " SELECT airport_code,\n" +
                "    airport_name ->> lang() AS airport_name,\n" +
                "    city ->> lang() AS city,\n" +
                "    coordinates,\n" +
                "    timezone\n" +
                "   FROM airports_data ml;";

        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                airport.setId(resultSet.getString(1));
                airport.setAirportName(resultSet.getString(2));
                airport.setCity(resultSet.getString(3));
                airport.setCoordinates(resultSet.getString(4));
                airport.setTimeZone(resultSet.getString(5));
                airports.add(airport);
            }
            return airports;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка полуения данных", e);
        }
    }
}

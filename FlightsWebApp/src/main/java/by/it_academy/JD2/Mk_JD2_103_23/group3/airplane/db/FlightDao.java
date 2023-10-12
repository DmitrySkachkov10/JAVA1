package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection.DataSourceCreator;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {
    DataSource ds = DataSourceCreator.getInstance();


    String sql = "SELECT f.flight_id,\n" +
            "    f.flight_no,\n" +
            "    f.scheduled_departure,\n" +
            "    timezone(dep.timezone, f.scheduled_departure) AS scheduled_departure_local,\n" +
            "    f.scheduled_arrival,\n" +
            "    timezone(arr.timezone, f.scheduled_arrival) AS scheduled_arrival_local,\n" +
            "    f.scheduled_arrival - f.scheduled_departure AS scheduled_duration,\n" +
            "    f.departure_airport,\n" +
            "    dep.airport_name AS departure_airport_name,\n" +
            "    dep.city AS departure_city,\n" +
            "    f.arrival_airport,\n" +
            "    arr.airport_name AS arrival_airport_name,\n" +
            "    arr.city AS arrival_city,\n" +
            "    f.status,\n" +
            "    f.aircraft_code,\n" +
            "    f.actual_departure,\n" +
            "    timezone(dep.timezone, f.actual_departure) AS actual_departure_local,\n" +
            "    f.actual_arrival,\n" +
            "    timezone(arr.timezone, f.actual_arrival) AS actual_arrival_local,\n" +
            "    f.actual_arrival - f.actual_departure AS actual_duration\n" +
            "   FROM flights f,\n" +
            "    airports dep,\n" +
            "    airports arr\n" +
            "  WHERE f.departure_airport = dep.airport_code AND f.arrival_airport = arr.airport_code";

    public FlightDao() {
    }

    @Override
    public List<Flight> getFlights() {

        List<Flight> flights = new ArrayList<>();

        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql + ";");
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                flights.add(new Flight(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getTimestamp(3),
                        resultSet.getTimestamp(4),
                        resultSet.getTimestamp(5),
                        resultSet.getTimestamp(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15)));
            }
            return flights;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка полуения данных", e);
        }
    }

    @Override
    public List<Flight> getFlights(int page, int size) {
        List<Flight> flights = new ArrayList<>();
        String sql = this.sql + " LIMIT " + size + " OFFSET " + ((page - 1) * size);

        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql + ";");
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                flights.add(new Flight(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getTimestamp(3),
                        resultSet.getTimestamp(4),
                        resultSet.getTimestamp(5),
                        resultSet.getTimestamp(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15)));
            }
            return flights;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка получения данных", e);
        }
    }

    @Override
    public List<Flight> getFlights(int page, int size, List<String> filters) {

        String sql = createFiltersRequest(page, size, filters);
        List<Flight> flights = new ArrayList<>();


        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                flights.add(new Flight(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getTimestamp(3),
                        resultSet.getTimestamp(4),
                        resultSet.getTimestamp(5),
                        resultSet.getTimestamp(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15)));
            }
            return flights;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка получения данных", e);
        }
    }

    private String createFiltersRequest(int page, int size, List<String> filters) {
        String pagination = " LIMIT " + size + " OFFSET " + ((page - 1) * size);
        StringBuffer bf = new StringBuffer();

        bf.append(this.sql);
        bf.append(" ORDER BY ");

        for (String filter : filters) {
            bf.append(filter + ", ");
        }

        bf.deleteCharAt(bf.length() - 1); //delete space
        bf.deleteCharAt(bf.length() - 1); // delete ',' symbol

        bf.append(pagination);

        bf.append(";");

        return bf.toString();
    }
}
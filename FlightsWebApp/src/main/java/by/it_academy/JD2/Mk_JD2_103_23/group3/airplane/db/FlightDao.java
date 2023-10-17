package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageSize;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection.DataSourceCreator;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {
    DataSource ds = DataSourceCreator.getInstance();

    private final static String GET_ALL_FLIGHT = "SELECT flight_id, flight_no, scheduled_departure, scheduled_departure_local, scheduled_arrival, scheduled_arrival_local, scheduled_duration, departure_airport, departure_airport_name, departure_city, arrival_airport, arrival_airport_name, arrival_city, status, aircraft_code, actual_departure, actual_departure_local, actual_arrival, actual_arrival_local, actual_duration FROM bookings.flights_v";

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
    public List<Flight> getFlights(FlightFilter filter, PageSize pageSize) {
        String sql = GET_ALL_FLIGHT;

        List<Object> params = new ArrayList<>();
        if (filter != null) {
            StringBuilder sqlBuilder = new StringBuilder();

            boolean needSeparator = false;
            if (filter.getArrivalAirport() != null) {
                if (needSeparator) {
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("arrival_airport = ?");
                params.add(filter.getArrivalAirport());
            }
            if (filter.getDepartureAirport() != null) {
                if (needSeparator) {
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("departure_airport = ?");
                params.add(filter.getDepartureAirport());
            }
            if (filter.getStatus() != null) {
                if (needSeparator) {
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("status = ?");
                params.add(filter.getStatus());
            }
            if (filter.getScheduledDeparture() != null) {
                if (needSeparator) {
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("scheduled_departure >= ? AND scheduled_departure < ?");
                params.add(filter.getScheduledDeparture());
                params.add(filter.getScheduledDeparture().plusDays(1));
            }
            if (filter.getScheduledArrival() != null) {
                if (needSeparator) {
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("scheduled_arrival >= ? AND scheduled_arrival < ?");
                params.add(filter.getScheduledArrival());
                params.add(filter.getScheduledArrival().plusDays(1));
            }

            if (sqlBuilder.length() > 0) {
                sqlBuilder.insert(0, " WHERE ");
                sql += sqlBuilder.toString();
            }
        }

        if (pageSize != null) {
            int size = pageSize.getSize();
            int page = pageSize.getPage();

            sql += " LIMIT ? OFFSET ?";
            params.add(size);
            params.add(((page - 1) * size));
        }

        try (Connection conn = ds.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
        ) {
            int index = 1;
            for (Object param : params) {
                stm.setObject(index++, param);
            }

            try (ResultSet rs = stm.executeQuery();) {
                List<Flight> data = new ArrayList<>();
                while (rs.next()) {
                    data.add(map(rs));
                }

                return data;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    public Flight map(ResultSet rs) throws SQLException {
        Flight item = new Flight();
        item.setFlightId(rs.getString("flight_id"));
        item.setFlightNo(rs.getString("flight_no"));
        item.setScheduledDeparture(rs.getString("scheduled_departure"));
        item.setScheduledDepartureLocal(rs.getString("scheduled_departure_local"));
        item.setScheduledArrival(rs.getString("scheduled_arrival"));
        item.setScheduledArrivalLocal(rs.getString("scheduled_arrival_local"));
        item.setScheduledDuration(rs.getString("scheduled_duration"));
        item.setDepartureAirport(rs.getString("departure_airport"));
        item.setDepartureAirportName(rs.getString("departure_airport_name"));
        item.setDepartureCity(rs.getString("departure_city"));
        item.setArrivalAirport(rs.getString("arrival_airport"));
        item.setArrivalAirportName(rs.getString("arrival_airport_name"));
        item.setArrivalCity(rs.getString("arrival_city"));
        item.setStatus(rs.getString("status"));
        item.setAircraftCode(rs.getString("aircraft_code"));
        item.setActualDeparture(rs.getString("actual_departure"));
        item.setActualDepartureLocal(rs.getString("actual_departure_local"));
        item.setActualArrival(rs.getString("actual_arrival"));

        return item;
    }
}



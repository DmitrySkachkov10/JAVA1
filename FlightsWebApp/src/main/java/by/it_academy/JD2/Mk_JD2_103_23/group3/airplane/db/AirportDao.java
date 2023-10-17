package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection.DataSourceCreator;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity.AirportEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDao implements IAirportDao {
    private DataSource ds = DataSourceCreator.getInstance();
    private AirportEntity airport = new AirportEntity();
    private List<AirportEntity> airports = new ArrayList<>();

    private final EntityManagerFactory emf;

    public AirportDao(EntityManagerFactory instance) {
        this.emf = instance;
    }


    @Override
    public List<AirportEntity> getAirports() {

        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<?> query = cb.createQuery();
        query.from(AirportEntity.class);
        return (List<AirportEntity>) em.createQuery(query).getResultList();

    }
}


//        String sql = "SELECT airport_code, airport_name, city, coordinates, timezone FROM airports_data;";
//
//        try (Connection connection = ds.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql);
//             ResultSet resultSet = ps.executeQuery()) {
//
//            while (resultSet.next()) {
//                airport.setAirportCode(resultSet.getString(1));
//                airport.setAirportName(resultSet.getString(2));
//                airport.setCity(resultSet.getString(3));
//                airport.setCoordinates(resultSet.getString(4));
//                airport.setTimezone(resultSet.getString(5));
//                airports.add(airport);
//            }
//            return airports;
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка полуения данных", e);
//        }
//    }
//}

package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection.DataSourceCreator;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirplaneDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.entity.AirCraftEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import javax.sql.DataSource;


import java.util.List;

public class AirplaneDao implements IAirplaneDao {

    private DataSource ds = DataSourceCreator.getInstance();

    private List<AirCraftEntity> airCrafts;

    private final EntityManagerFactory emf;

    public AirplaneDao(EntityManagerFactory emf)  {
        this.emf = emf;
    }


    @Override
    public List<AirCraftEntity> getAirCrafts()  {
//        airCrafts = new ArrayList<>();
//
//        String sql = "SELECT aircraft_code," +
//                " model ->> lang() AS model," +
//                " range FROM aircrafts_data;";
//
//
//        try (Connection conn = ds.getConnection();
//             PreparedStatement stm = conn.prepareStatement(sql);
//             ResultSet resultSet = stm.executeQuery()) {
//            while (resultSet.next()){
//                airCrafts.add(new AirCraftEntity(resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getInt(3)));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка полуения данных", e);
//        }
//        return airCrafts;

        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<?> query = cb.createQuery();
        query.from(AirCraftEntity.class);
        return (List<AirCraftEntity>) em.createQuery(query).getResultList();
    }
}

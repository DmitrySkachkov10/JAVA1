package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.AirCraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirplaneDao;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDao implements IAirplaneDao {

    private DataSource ds = DataSourceCreator.getInstance();

    private List<AirCraft> airCrafts;

    public AirplaneDao()  {
    }


    @Override
    public List<AirCraft> getAirCrafts()  {
        airCrafts = new ArrayList<>();

        String sql = "SELECT aircraft_code," +
                " model ->> lang() AS model," +
                " range FROM aircrafts_data;";


        try (Connection conn = ds.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet resultSet = stm.executeQuery()) {
            while (resultSet.next()){
                airCrafts.add(new AirCraft(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка полуения данных", e);
        }
        return airCrafts;
    }
}

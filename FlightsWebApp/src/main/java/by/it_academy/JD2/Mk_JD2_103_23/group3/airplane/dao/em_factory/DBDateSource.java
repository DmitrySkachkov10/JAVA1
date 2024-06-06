package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.em_factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DBDateSource {
    private static ComboPooledDataSource ds;
    static {
        ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass( "org.postgresql.Driver" );
        } catch (PropertyVetoException e) {
            throw new IllegalStateException("Ошибка инициализации драйвера базы", e);
        }
        ds.setJdbcUrl( "jdbc:postgresql://db:5432/demo" );
        ds.setUser("postgres");
        ds.setPassword("kitanax");
    }

    public static DataSource getInstance() {
        return ds;
    }
}

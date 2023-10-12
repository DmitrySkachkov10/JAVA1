package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DataSourceCreator {

    private static volatile DataSourceCreator instance;

    private ComboPooledDataSource cpds;

    private static final Properties properties = new Properties();

    private DataSourceCreator() throws  PropertyVetoException {

        try (InputStream input = DataSourceCreator.class.getResourceAsStream("/db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(properties.getProperty("db.driver"));
        cpds.setJdbcUrl(properties.getProperty("db.url"));
        cpds.setUser(properties.getProperty("db.user"));
        cpds.setPassword(properties.getProperty("db.password"));
        cpds.setMinPoolSize(Integer.parseInt(properties.getProperty("db.minPoolSize")));
        cpds.setAcquireIncrement(Integer.parseInt(properties.getProperty("db.acquireIncrement")));
        cpds.setMaxPoolSize(Integer.parseInt(properties.getProperty("db.maxPoolSize")));
        cpds.setMaxStatements(Integer.parseInt(properties.getProperty("db.maxStatements")));
    }

    public static DataSource getInstance()  {
        if (instance == null) {
            synchronized (DataSourceCreator.class) {
                try {
                    instance = new DataSourceCreator();
                } catch (PropertyVetoException e) {
                    throw new RuntimeException("Ошибка подключния драйвера" , e);
                }
            }
        }
        return instance.cpds;
    }
}

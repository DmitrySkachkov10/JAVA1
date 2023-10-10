package by.dmitry_skachkov.projects;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws SQLException {



        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        ds.setJdbcUrl( "jdbc:postgresql://localhost:5432/books_app" );
        ds.setUser("postgres");
        ds.setPassword("postgres");



        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги");
        String name = scanner.nextLine();

        System.out.println("Введите имя автора");
        String author = scanner.nextLine();

        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++) {
            try (Connection conn = ds.getConnection();
                 PreparedStatement stm = conn.prepareStatement("INSERT INTO books.books(id, name, author)" +
                         " VALUES (?, ?, ?);");) {

                stm.setObject(1, UUID.randomUUID());
                stm.setObject(2, name);
                stm.setObject(3, author);

                stm.execute();
            }
        }

        long stop = System.currentTimeMillis();

        System.out.println("заняло - " + (stop - start));
//            ResultSet resultSet = st.executeQuery(sql);
//        long stop = System.currentTimeMillis();

    }

}

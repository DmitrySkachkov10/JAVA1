package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFFactory {
    private final static EntityManagerFactory instance;

    static {
        instance =
                Persistence.createEntityManagerFactory("test");
    }

    public static EntityManagerFactory getInstance() {
        return instance;
    }
}

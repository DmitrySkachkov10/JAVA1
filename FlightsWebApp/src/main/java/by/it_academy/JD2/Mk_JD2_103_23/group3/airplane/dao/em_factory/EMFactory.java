package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.em_factory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.config.PropertiesFactoryBean;

public class EMFactory {
    private final static EntityManagerFactory instance;

    static {
        instance = Persistence.createEntityManagerFactory("test");
    }

    public static EntityManagerFactory getInstance() {return instance;}

}

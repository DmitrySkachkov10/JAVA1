package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.AirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection.EMFFactory;


public class AirportDaoFactory {
    private volatile static AirportDao instance;

    private AirportDaoFactory(){
    }

    public static IAirportDao getInstance()  {
        if (instance == null) {
            synchronized (AirportDaoFactory.class) {
                if (instance == null) {

                        instance = new AirportDao(EMFFactory.getInstance());

                }
            }
        }
        return instance;
    }
}
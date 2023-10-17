package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.FlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.connection.EMFFactory;


public class FlightDaoFactory {
    private volatile static FlightDao instance;

    private FlightDaoFactory() {
    }

    public static IFlightDao getInstance() {
        if (instance == null) {
            synchronized (FlightDaoFactory.class) {
                if (instance == null) {

                    instance = new FlightDao(EMFFactory.getInstance());

                }
            }
        }
        return instance;
    }
}

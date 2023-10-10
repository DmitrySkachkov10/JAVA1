package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory.AirportDaoFactory;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.AirportService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;



public class AirportServiceFactory {
    private volatile static AirportService instance;

    private AirportServiceFactory() {
    }

    public static IAirportService getInstance() {
        if (instance == null) {
            synchronized (AirportServiceFactory.class) {
                if (instance == null) {
                    instance = new AirportService(AirportDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}

package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory.AirplaneDaoFactory;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.AirplaneService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirplaneService;


public class AirplaneServiceFactory {
    private volatile static AirplaneService instance;

    private AirplaneServiceFactory() {
    }

    public static IAirplaneService getInstance() {
        if (instance == null) {
            synchronized (AirplaneServiceFactory.class) {
                if (instance == null) {
                    instance = new AirplaneService(AirplaneDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}

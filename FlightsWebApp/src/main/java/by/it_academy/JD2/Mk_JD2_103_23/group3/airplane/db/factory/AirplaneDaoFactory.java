package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.AirplaneDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirplaneDao;



public class AirplaneDaoFactory {
    private volatile static AirplaneDao instance;

    private AirplaneDaoFactory() {
    }

    public static IAirplaneDao getInstance() {
        if (instance == null) {
            synchronized (AirplaneDaoFactory.class) {
                if (instance == null) {

                    instance = new AirplaneDao();

                }
            }
        }
        return instance;
    }
}

package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory.FlightDaoFactory;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.FlightService;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;

public class FlightServiceFactory {
    private volatile static FlightService instance;

    private FlightServiceFactory(){
    }

    public static IFlightService getInstance(){
        if (instance == null) {
            synchronized (FlightServiceFactory.class) {
                if (instance == null) {
                    instance = new FlightService (FlightDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}

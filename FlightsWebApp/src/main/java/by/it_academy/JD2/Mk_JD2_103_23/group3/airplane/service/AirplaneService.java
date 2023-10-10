package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory.AirplaneDaoFactory;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.AirCraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirplaneDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirplaneService;


import java.util.List;

public class AirplaneService implements IAirplaneService {

    private IAirplaneDao airplaneDao = AirplaneDaoFactory.getInstance();


    public AirplaneService(IAirplaneDao instance) {
        this.airplaneDao = instance;
    }

    @Override
    public List<AirCraft> getAirCrafts() {

        return airplaneDao.getAirCrafts();

    }
}

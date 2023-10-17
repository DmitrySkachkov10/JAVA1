package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.AirCraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.factory.AirplaneDaoFactory;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api.IAirplaneDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirplaneService;


import java.util.List;
import java.util.stream.Collectors;

public class AirplaneService implements IAirplaneService {

    private IAirplaneDao airplaneDao = AirplaneDaoFactory.getInstance();


    public AirplaneService(IAirplaneDao instance) {
        this.airplaneDao = instance;
    }

    @Override
    public List<AirCraft> getAirCrafts() {

        return airplaneDao.getAirCrafts()
                .stream()
                .map(airCraftEntity -> new AirCraft(airCraftEntity.getAircraft_code(),
                        airCraftEntity.getModel(), airCraftEntity.getRange())).collect(Collectors.toList());

    }
}

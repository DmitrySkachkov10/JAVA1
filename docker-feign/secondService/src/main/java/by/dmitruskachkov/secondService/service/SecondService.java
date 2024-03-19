package by.dmitruskachkov.secondService.service;

import by.dmitruskachkov.secondService.service.api.FeignService2;
import by.dmitruskachkov.secondService.service.api.ISecondService;
import org.springframework.stereotype.Service;

@Service
public class SecondService implements ISecondService {

    private FeignService2 feignService2;

    public SecondService(FeignService2 feignService2) {
        this.feignService2 = feignService2;
    }

    @Override
    public String makeTest() {
        return "ok from second service";
    }

    @Override
    public String makeFeignTest() {
        //claim data from second service
        return feignService2.getDataFromFirstService();
    }
}

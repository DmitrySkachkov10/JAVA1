package by.dmitruskachkov.firstService.service;

import by.dmitruskachkov.firstService.service.api.FeignService;
import by.dmitruskachkov.firstService.service.api.IFirstService;
import org.springframework.stereotype.Service;

@Service
public class FirstService implements IFirstService {

    private final FeignService feignService;

    public FirstService(FeignService feignService) {
        this.feignService = feignService;
    }

    @Override
    public String makeTest() {
        return "ok from first service";
    }

    @Override
    public String makeFeignTest() {
        //claim data from second service
        return feignService.getDataFromSecondService();
    }
}

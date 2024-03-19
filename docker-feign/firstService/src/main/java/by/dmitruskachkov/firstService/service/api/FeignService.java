package by.dmitruskachkov.firstService.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "secondService", url = "${my.app.feign.address}")
public interface FeignService {

    @GetMapping("/test2")
    String getDataFromSecondService();
}

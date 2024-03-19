package by.dmitruskachkov.secondService.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "firstService", url = "${my.app.feign.address}")
public interface FeignService2 {

    @GetMapping("/test1")
    String getDataFromFirstService();
}

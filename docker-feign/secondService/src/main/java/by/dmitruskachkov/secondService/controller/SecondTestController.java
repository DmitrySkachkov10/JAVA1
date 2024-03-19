package by.dmitruskachkov.secondService.controller;

import by.dmitruskachkov.secondService.service.api.ISecondService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondTestController {
    private final ISecondService secondService;

    public SecondTestController(ISecondService secondService) {
        this.secondService = secondService;
    }

    @GetMapping("/test2")
    public ResponseEntity<String> makeTest2() {
        return new ResponseEntity<>(secondService.makeTest(), HttpStatus.OK);
    }

    @GetMapping("/feigntest2")
    public ResponseEntity<String> makeFeignTest2() {
        return new ResponseEntity<>(secondService.makeFeignTest(), HttpStatus.OK);
    }
}

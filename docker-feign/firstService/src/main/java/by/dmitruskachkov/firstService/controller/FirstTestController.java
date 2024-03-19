package by.dmitruskachkov.firstService.controller;

import by.dmitruskachkov.firstService.service.api.IFirstService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstTestController {

    private final IFirstService firstService;

    public FirstTestController(IFirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/test1")
    public ResponseEntity<String> makeTest() {
        return new ResponseEntity<>(firstService.makeTest(), HttpStatus.OK);
    }

    @GetMapping("/feigntest")
    public ResponseEntity<String> makeFeignTest() {
        return new ResponseEntity<>(firstService.makeFeignTest(), HttpStatus.OK);
    }
}

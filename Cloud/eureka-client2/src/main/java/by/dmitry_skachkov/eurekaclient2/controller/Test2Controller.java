package by.dmitry_skachkov.eurekaclient2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main2")
public class Test2Controller {

    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
}

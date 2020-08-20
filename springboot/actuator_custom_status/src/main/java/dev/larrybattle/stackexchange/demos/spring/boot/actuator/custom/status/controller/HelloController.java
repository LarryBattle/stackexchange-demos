package dev.larrybattle.stackexchange.demos.spring.boot.actuator.custom.status.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hi")
    public String index(){
        return "Hello World";
    }
}

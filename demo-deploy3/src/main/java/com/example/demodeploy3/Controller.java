package com.example.demodeploy3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${devName}")
    private String devName;

    @Value("${authCode}")
    private String authCode;

    @GetMapping("/greeting")
    public String getGreeting() {
        return "Benvenuto " + devName + "! Il tuo codice auth è: " + authCode;
    }
}

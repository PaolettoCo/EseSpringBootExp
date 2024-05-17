package com.example.demodeploy4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerD3 {
    @Value("${welcomeMsg}")
    private String welcomeMsg;

    @GetMapping("/greeting")
    public String getGreeting() {
        return welcomeMsg;
    }
}

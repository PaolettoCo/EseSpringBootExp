package com.example.demodeploy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Value("${devName}")
    private String devName;
    @GetMapping("/devName")
    public String getName(){
        return "devName: " + devName;
    }
}

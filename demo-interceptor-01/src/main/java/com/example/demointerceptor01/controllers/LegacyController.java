package com.example.demointerceptor01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegacyController {

    @GetMapping("/legacy")
    public String legacyEndpoint() {
        return "This is just old code";
    }
}

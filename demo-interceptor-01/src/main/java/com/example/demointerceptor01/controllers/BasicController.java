package com.example.demointerceptor01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BasicController {

    @GetMapping("/basic")
    public String currentTime() {
        return "current date/time: " + LocalDateTime.now();
    }
}

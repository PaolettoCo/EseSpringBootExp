package com.example.demointerceptor01.month.controller;

import com.example.demointerceptor01.month.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthController {

    private final HttpServletRequest request;

    public MonthController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping("/root")
    public String welcomes(){
        return "welcome";
    }

    @GetMapping("/months")
    public Month getMonth(){
        return (Month) request.getAttribute("monthNumber");
    }
}

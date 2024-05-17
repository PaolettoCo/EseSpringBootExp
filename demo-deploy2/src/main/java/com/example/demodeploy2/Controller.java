package com.example.demodeploy2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Controller {

    @GetMapping("/random-sum")
    public int randomSum() {
        Random random = new Random();
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        return num1 + num2;
    }
}

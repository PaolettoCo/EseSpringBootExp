package com.example.demoservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${ENV_VAR1}")
    private int envVar1;

    @Value("${ENV_VAR2}")
    private int envVar2;

    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public String welcome() {
        logger.info("Richiesta ricevuta per la rotta /");
        return "Benvenuto!";
    }

    @GetMapping("/exp")
    public int calculateExponent() {
        logger.info("Inizio calcolo esponente");
        int result = (int) Math.pow(envVar1, envVar2);
        logger.info("Risultato calcolo esponente: " + result);
        return result;
    }

    @GetMapping("/get-errors")
    public void generateError() {
        logger.error("Generando un errore personalizzato");
        throw new MyException("Errore personalizzato!");
    }

}

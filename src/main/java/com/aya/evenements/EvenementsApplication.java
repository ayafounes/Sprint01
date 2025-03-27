package com.aya.evenements;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aya.evenements.entities.Evenement;
import com.aya.evenements.service.EvenementService;

@SpringBootApplication
public class EvenementsApplication implements CommandLineRunner {

    @Autowired
    EvenementService evenementService;

    public static void main(String[] args) {
        SpringApplication.run(EvenementsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        evenementService.saveEvenement(new Evenement("Concert Jazz", 50.0, new Date()));
        evenementService.saveEvenement(new Evenement("Conférence Tech", 0.0, new Date()));
        evenementService.saveEvenement(new Evenement("Festival Culturel", 120.0, new Date()));
    }
}
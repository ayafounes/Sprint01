package com.aya.evenements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.aya.evenements.entities.Evenement;
import com.aya.evenements.repos.EvenementRepository;
import com.aya.evenements.service.EvenementService;

@SpringBootTest
class EvenementsApplicationTests {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private EvenementService evenementService;  // Ajouter cette annotation ici

    @Test
    public void testCreateEvenement() {
        Evenement event = new Evenement("Coachella", 200.0, new Date());
        evenementRepository.save(event);
    }

    @Test
    public void testFindEvenement() {
        Evenement e = evenementRepository.findById(1L).get();
        System.out.println(e);
    }

    @Test
    public void testUpdateEvenement() {
        Evenement e = evenementRepository.findById(2L).get();
        e.setPrixEvenement(1000.0);
        evenementRepository.save(e);
    }

    @Test
    public void testDeleteEvenement() {
        evenementRepository.deleteById(3L);
    }

    @Test
    public void testListerTousEvenements() {
        List<Evenement> events = evenementRepository.findAll();
        for (Evenement e : events) {
            System.out.println(e);
        }
    }

    @Test
    public void testFindByNomEvenementContains() {
        Page<Evenement> events = evenementService.getAllEvenementsParPage(0, 2);
        System.out.println(events.getSize());
        System.out.println(events.getTotalElements());
        System.out.println(events.getTotalPages());
        events.getContent().forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
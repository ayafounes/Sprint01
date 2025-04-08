package com.aya.evenements.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aya.evenements.entities.Evenement;
import com.aya.evenements.service.EvenementService;

@RestController
@RequestMapping("/api/evenements")
@CrossOrigin
public class EvenementRESTController {

    @Autowired
    EvenementService evenementService;

    @GetMapping
    public List<Evenement> getAllEvenements() {
        return evenementService.getAllEvenements();
    }
    @GetMapping("/{id}")
    public Evenement getEvenementById(@PathVariable("id") Long id) {
        return evenementService.getEvenement(id);
    }
    @PostMapping
    public Evenement createEvenement(@RequestBody Evenement evenement) {
        return evenementService.saveEvenement(evenement);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteEvenement(@PathVariable("id") Long id)
    {
        evenementService.deleteEvenementById(id);
    }
    @RequestMapping(value="/evenementsgenre/{idGenre}", method = RequestMethod.GET)
    public List<Evenement> getEvenementsByGenreId(@PathVariable("idGenre") Long idGenre) {
        return evenementService.findByGenreIdGenre(idGenre);
    }
}
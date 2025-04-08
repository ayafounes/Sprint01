package com.aya.evenements.service;

import java.util.List;

import com.aya.evenements.entities.Evenement;
import com.aya.evenements.entities.Genre;

public interface EvenementService {
    Evenement saveEvenement(Evenement e);
    Evenement updateEvenement(Evenement e);
    void deleteEvenement(Evenement e);
    void deleteEvenementById(Long id);
    Evenement getEvenement(Long id);
    List<Evenement> getAllEvenements();
    List<Evenement> findByNomEvenement(String nom);
    List<Evenement> findByNomEvenementContains(String nom);
    List<Evenement> findByNomPrix(String nom, Double prix);
    List<Evenement> findByGenre(Genre genre);
    List<Evenement> findByGenreIdGenre(Long id);
    List<Evenement> findByOrderByNomEvenementAsc();
    List<Evenement> trierEvenementsNomsPrix();
}
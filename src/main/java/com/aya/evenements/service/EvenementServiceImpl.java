package com.aya.evenements.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.aya.evenements.entities.Evenement;
import com.aya.evenements.entities.Genre;
import com.aya.evenements.repos.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    EvenementRepository evenementRepository;

    @Override
    public Evenement saveEvenement(Evenement e) {
        return evenementRepository.save(e);
    }

    @Override
    public Evenement updateEvenement(Evenement e) {
        return evenementRepository.save(e);
    }

    @Override
    public void deleteEvenement(Evenement e) {
        evenementRepository.delete(e);
    }

    @Override
    public void deleteEvenementById(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement getEvenement(Long id) {
        return evenementRepository.findById(id).get();
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }
    
    @Override
    public List<Evenement> findByNomEvenement(String nom) {
        return evenementRepository.findByNomEvenement(nom);
    }

    @Override
    public List<Evenement> findByNomEvenementContains(String nom) {
        return evenementRepository.findByNomEvenementContains(nom);
    }

    @Override
    public List<Evenement> findByNomPrix(String nom, Double prix) {
        return evenementRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Evenement> findByGenre(Genre genre) {
        return evenementRepository.findByGenre(genre);
    }

    @Override
    public List<Evenement> findByGenreIdGenre(Long id) {
        return evenementRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Evenement> findByOrderByNomEvenementAsc() {
        return evenementRepository.findByOrderByNomEvenementAsc();
    }

    @Override
    public List<Evenement> trierEvenementsNomsPrix() {
        return evenementRepository.trierEvenementsNomsPrix();
    }

}
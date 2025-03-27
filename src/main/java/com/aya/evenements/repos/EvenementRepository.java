package com.aya.evenements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aya.evenements.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
}

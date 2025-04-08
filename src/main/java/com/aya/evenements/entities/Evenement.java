package com.aya.evenements.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Evenement {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;
    private String nomEvenement;
    private Double prixEvenement;
    private Date dateEvenement;
    
    @ManyToOne
	private Genre genre;
    public Evenement() {
        super();
    }

    public Evenement(String nomEvenement, Double prixEvenement, Date dateEvenement) {
        super();
        this.nomEvenement = nomEvenement;
        this.prixEvenement = prixEvenement;
        this.dateEvenement = dateEvenement;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public Double getPrixEvenement() {
        return prixEvenement;
    }

    public void setPrixEvenement(Double prixEvenement) {
        this.prixEvenement = prixEvenement;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    @Override
    public String toString() {
        return "Evenement [idEvenement=" + idEvenement + ", nomEvenement=" + nomEvenement + ", prixEvenement=" + prixEvenement
                + ", dateEvenement=" + dateEvenement + "]";
    }
}
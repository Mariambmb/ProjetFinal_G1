package com.inti.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="g1_offre")
@Entity @AllArgsConstructor @NoArgsConstructor @Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Offre {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type_bien;
    private String adresse;
    private String ville;
    private double prix;
    private double surface;
    private int nb_piece;
    private boolean meuble;
    private boolean achat;
    private boolean exterieur;
    private String croquis;
    private String note;

    

@ManyToOne
@JoinColumn(name = "id_agence_immmobiliere")
private AgenceImmobiliere agence_immobiliere;
}
package com.inti.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="g1_client")
@Entity @AllArgsConstructor @NoArgsConstructor @Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@PrimaryKeyJoinColumn(name="id_client")
public class Client extends Personne {

   
    private String adresse;
    private String telephone;
    private List<Offre> listePropOffres;
    
    @OneToMany(mappedBy = "client")
    private List<Questions> listeQuestions;

	public Client(int id, String nom, String prenom, String login, String mdp, String mail, String adresse,
			String telephone) {
		super(id, nom, prenom, login, mdp, mail);
		this.adresse = adresse;
		this.telephone = telephone;	
	}
    
    public void consulterListOffres() {
        // TODO implement here
    }

    
    public void consulterInfoOffres() {
        // TODO implement here
    }

    public void evaluerOffres() {
        // TODO implement here
    }

    public void rechercheAvancee() {
        // TODO implement here
    }




	

}
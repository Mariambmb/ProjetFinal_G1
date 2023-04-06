package com.inti.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.ToString.Exclude;

@Table(name = "g1_gerant")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@PrimaryKeyJoinColumn(name = "id_gerant")
public class Gerant extends Personne {

	@OneToMany(mappedBy = "gerant")
	@Exclude
	@JsonIgnore
	private List<Questions> listeQuestions;

	public Gerant() {
		super();
	}

	public Gerant(int id, String nom, String prenom, String login, String mdp, String mail) {
		super(id, nom, prenom, login, mdp, mail);
	}

	public void propOffres() {

	}

	public void propCroquis() {

	}

	public void repClients() {

	}

}
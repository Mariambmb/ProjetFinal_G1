package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Client;
import com.inti.model.Gerant;
import com.inti.model.Offre;
import com.inti.repository.IClientRepository;
import com.inti.repository.IGerantRepository;
import com.inti.repository.IOffreRepository;

@RestController
@RequestMapping("gerant")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class GerantController {
	@Autowired
	IClientRepository icr;
	@Autowired
	IOffreRepository ior;
	@Autowired
	IGerantRepository igr; 

	@GetMapping("listeClients")
	public List<Client> listeClients() {
		List<Client> listeClients = icr.findAll();
		return listeClients;
	}

	@GetMapping("clientId/{id}")
	public Client clientId(@PathVariable("id") int id) {
		System.out.println("id : " + id);
		return icr.getReferenceById(id);
	}

	@GetMapping("listeOffres")
	public List<Offre> listeOffres() {
		List<Offre> listeOffres = ior.findAll();
		return listeOffres;
	}

	@GetMapping("offreId/{id}")
	public Offre offreId(@PathVariable("id") int id) {
		System.out.println("id : " + id);
		return ior.getReferenceById(id);
	}

	@PostMapping("saveOffre")
	public Offre saveOffre(@RequestBody Offre o) {
		return ior.save(o);
	}

	@DeleteMapping("deleteOffre/{id}")
	public void deleteOffre(@PathVariable("id") int id) {
		ior.deleteById(id);
	}

	@PutMapping("updateOffre")
	public void updateOffre(@RequestBody Offre o) {
		ior.save(o);
	}

	@GetMapping("listePropositions/{idGerant}")
	public List<Offre> listePropositions(@PathVariable int idGerant) {
		return igr.getReferenceById(idGerant).getListePropositionOffre();
	}

	@PutMapping("ajoutPropOffre/{idOffre}/{idGerant}")
	public void ajoutPropositionOffre(@PathVariable int idOffre, @PathVariable int idGerant) {
		Gerant g = igr.getReferenceById(idGerant);
		Offre o = ior.getReferenceById(idOffre);

		System.out.println("Récupération du gérant " + g.getId() + "pour l'offre " + o.getId());
		System.out.println("taille de la liste avant ajout : " + g.getListePropositionOffre().size());

		g.getListePropositionOffre().add(o);
		igr.save(g);

		System.out.println("taille de la liste après ajout : " + g.getListePropositionOffre().size());
		System.out.println("liste proposition après ajout" + g.getListePropositionOffre());
	}

	@DeleteMapping("deletePropOffre/{idOffre}/{idGerant}")
	public void deletePropOffre(@PathVariable int idOffre, @PathVariable int idGerant) {
		Gerant g = igr.getReferenceById(idGerant);
		System.out.println("taille de la liste avant retrait : " + g.getListePropositionOffre().size());

		g.getListePropositionOffre().remove(ior.getReferenceById(idOffre));
		igr.save(g);

		System.out.println("taille de la liste après retrait : " + g.getListePropositionOffre().size());
	}
	
	
	@PostMapping("ajouterGerant")
	public Gerant inscriptionGerant(@RequestBody Gerant g)
	{
			
		return igr.save(g);
	}
		
	@GetMapping("getGerants")
	public List<Gerant> getGerants()
	{
		return igr.findAll();
	}
}

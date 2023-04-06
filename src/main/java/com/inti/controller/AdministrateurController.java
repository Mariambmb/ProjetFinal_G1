package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.AdminAttente;
import com.inti.model.Administrateur;
import com.inti.model.Client;
import com.inti.model.ClientAttente;
import com.inti.model.Gerant;
import com.inti.model.GerantAttente;
import com.inti.repository.IAdminAttenteRepository;
import com.inti.repository.IAdministrateurRepository;
import com.inti.repository.IClientAttenteRepository;
import com.inti.repository.IClientRepository;
import com.inti.repository.IGerantAttenteRepository;
import com.inti.repository.IGerantRepository;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class AdministrateurController {

	@Autowired
	IAdministrateurRepository iar;
	
	@Autowired
	IAdminAttenteRepository iaar;
	
	@Autowired
	IClientRepository icr;
	
	@Autowired
	IClientAttenteRepository icar;
	
	@Autowired
	IGerantRepository igr; 
	
	@Autowired
	IGerantAttenteRepository igar; 
	
	// Client
	@PostMapping("ajouterClient")
	public ClientAttente inscriptionClient(@RequestBody ClientAttente c)
	{
		return icar.save(c);
	}
	 
	@GetMapping("getClientsAttente")
	public List<ClientAttente> getClientsAttente()
	{
		return icar.findAll();
	}
	
	@DeleteMapping("deleteClientAttente/{id}")
	public void deleteClientAttente(@PathVariable("id") int id)
	{
		icar.deleteById(id);
	}
	
    // Validation du compte client
	@PostMapping("validerClient")
	public void validerClientAttente(@RequestBody Client c)
	{
		icr.save(c);
	}
	
	@GetMapping("getClientsValide")
	public List<Client> getClients()
	{
		return icr.findAll();
	}
	
	@GetMapping("getClientById/{id}")
	public Client getClientById(@PathVariable("id") int id)
	{
		return icr.getReferenceById(id);
	}
	
	@DeleteMapping("deleteClientValide/{id}")
	public void deleteClient(@PathVariable("id") int id)
	{
		icr.deleteById(id);
	}
	
	@PutMapping("updateClient")
	public void updateClient(@RequestBody Client c)
	{
		icr.save(c);
	}
	
	// Admin
	@PostMapping("ajouterAdmin")
	public AdminAttente inscriptionAdmin(@RequestBody AdminAttente a)
	{
		return iaar.save(a);
	}

	@GetMapping("getAdminsAttente")
	public List<AdminAttente> getAdminsAttente()
	{
		return iaar.findAll();
	}
	
	@DeleteMapping("deleteAdminAttente/{id}")
	public void deleteAdminAttente(@PathVariable("id") int id)
	{
		iaar.deleteById(id);
	}
	
	 // Validation du compte admin	
	@PostMapping("validerAdmin")
	public void validerAdminAttente(@RequestBody Administrateur a)
	{
		iar.save(a);
	}
	
	@GetMapping("getAdminsValide")
	public List<Administrateur> getAdmins()
	{
		return iar.findAll();
	}
	
	@GetMapping("getAdminById/{id}")
	public Administrateur getAdminById(@PathVariable("id") int id)
	{
		return iar.getReferenceById(id);
	}
	
	@DeleteMapping("deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id") int id)
	{
		iar.deleteById(id);
	}

	
	// Gerant
	@PostMapping("ajouterGerant")
	public GerantAttente inscriptionGerant(@RequestBody GerantAttente g)
	{
			
		return igar.save(g);
	}
		
	@GetMapping("getGerantsAttente")
	public List<GerantAttente> getGerantsAttente()
	{
		return igar.findAll();
	}
	
	@DeleteMapping("deleteGerantAttente/{id}")
	public void deleteGerantAttente(@PathVariable("id") int id)
	{
		igar.deleteById(id);
	}
	
	 // Validation du compte admin
	@PostMapping("validerGerant")
	public void validerGerantAttente(@RequestBody Gerant g)
	{
		igr.save(g);
	}

	@GetMapping("getGerantsValide")
	public List<Gerant> getGerants()
	{
		return igr.findAll();
	}
	
	@GetMapping("getGerantById/{id}")
	public Gerant getGerantById(@PathVariable("id") int id)
	{
		return igr.getReferenceById(id);
	}
		
	@DeleteMapping("deleteGerantValide/{id}")
	public void deleteGerant(@PathVariable("id") int id)
	{
		igr.deleteById(id);
	}
	
	@PutMapping("updateGerant")
	public void updateGerant(@RequestBody Gerant g)
	{
		igr.save(g);
	}
}

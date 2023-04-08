import { Component } from '@angular/core';
import { ClientService } from '../service/client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Offre } from '../model/offre.model';

@Component({
  selector: 'app-propositions-client',
  templateUrl: './propositions-client.component.html',
  styleUrls: ['./propositions-client.component.css']
})
export class PropositionsClientComponent {
  constructor(private http: HttpClient,private ar:ActivatedRoute, private cs:ClientService ,  private router:Router ) { }

  listePropositions$!:Observable<Offre[]>;
  idClient=Number(sessionStorage.getItem('id'));
  
  ngOnInit():Observable<Offre[]> {
   
   return this.listePropositions$= this.cs.getListePropositions(this.idClient);
  }
  
  connecte = sessionStorage.getItem('connecte')
  
  retirerProposition(idOffre:number)
  {
    alert ("L'offre "+idOffre + " va être retirée de votre liste d'offres sauvegardées. ")
    location.reload();
    return this.cs.retirerProposition(idOffre,this.idClient).subscribe();
    
  }

  noter(idOffre:number){
  //A REMPLIR 
  }

}

import { Injectable } from '@angular/core';
import { Offre } from '../model/offre.model';

@Injectable({
  providedIn: 'root'
})
export class OffreService {

  listeO:Offre[]=[
    new Offre(1,"appartement","15 rue mystere","Montpellier",850,45,3,true,false,false,"",4),
    new Offre(2,"maison","666 rue Ducomplot","Grabel",356000,100,5,false,true,true,"",5),
    new Offre(3,"studio","120 place Liberté","Paris",278000,20,1,true,false,false,"",2),
  ];

  constructor() { }
  
  getListeOffres(){
return this.listeO;
  }
}

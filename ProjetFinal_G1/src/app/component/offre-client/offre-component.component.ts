import { Component, OnInit } from '@angular/core';
import { Offre } from 'src/app/model/offre.model';
import { OffreService } from 'src/app/service/offre.service';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-offre-component',
  templateUrl: './offre-component.component.html',
  styleUrls: ['./offre-component.component.css']
})
export class OffreComponentComponent implements OnInit {
  
  constructor(private http: HttpClient,private os:OffreService) { }

  listeOffres$!:Observable<Offre[]>;
  ngOnInit(): void {
    this.listeOffres$= this.os.getListeOffres();
  }

}

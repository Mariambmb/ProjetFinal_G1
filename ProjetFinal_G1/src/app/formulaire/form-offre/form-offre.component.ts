import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Offre } from 'src/app/model/offre.model';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { OffreService } from 'src/app/service/offre.service';

@Component({
  selector: 'app-form-offre',
  templateUrl: './form-offre.component.html',
  styleUrls: ['./form-offre.component.css']
})
export class FormOffreComponent implements OnInit {

  constructor(private fb: FormBuilder, private http: HttpClient, private os: OffreService) { }

  ngOnInit(): void {
    this.offreForm = this.fb.group({
      type_bien: "",
      adresse: "",
      ville: "",
      prix: 0,
      surface: 0,
      nb_piece: 0,
      meuble: false,
      achat: false,
      exterieur: false,
      croquis: ""

    })
  }

  type_bien: string = "";
  adresse: string = "";
  ville: string = "";
  prix!: number;
  surface!: number;
  nb_piece!: number;
  meuble!: boolean;
  achat!: boolean;
  exterieur!: boolean;
  croquis: string = "";

  savedOffre!: Offre;
  offreForm!: FormGroup;
  savedMeuble!: boolean;
  savedExt!: boolean;
  savedAchat!: boolean;

  addOffre() {
    this.os.saveOffre(this.offreForm.value).subscribe();
    if (this.os.saveOffre(this.offreForm.value).subscribe() != null) {
      alert("Offre " + this.offreForm.value.adresse + " ajoutée");
      console.log(this.offreForm.value);
      location.reload();
    } else {
      alert("ECHEC de l'enregistrement ");
    }
  }

}

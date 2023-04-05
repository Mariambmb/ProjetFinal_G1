import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormClientComponent } from './form-client/form-client.component';
import { ListeClientComponent } from './liste-client/liste-client.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FormOffreComponent } from './formulaire/form-offre/form-offre.component';
import { OffreGerantComponent } from './component/offre-gerant/offre-gerant.component';
import { BrowserModule } from '@angular/platform-browser';
import { QuestionComponent } from './component/question/question.component';
import { FormulaireQuestionComponent } from './FormulairesQuestion/formulaire-question/formulaire-question.component';
import { FormRepondreComponent } from './FormulairesQuestion/form-repondre/form-repondre.component';


@NgModule({
  declarations: [
    AppComponent,
    FormClientComponent,
    ListeClientComponent,
    AccueilComponent,
    FormOffreComponent,
    OffreGerantComponent,
    QuestionComponent,
    FormulaireQuestionComponent,
    FormRepondreComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent, FormClientComponent]
})
export class AppModule { }

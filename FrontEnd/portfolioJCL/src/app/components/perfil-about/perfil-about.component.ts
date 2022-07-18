import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Persona } from 'src/app/models/persona';
import { PerfilAboutService } from 'src/app/services/perfil-about.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-perfil-about',
  templateUrl: './perfil-about.component.html',
  styleUrls: ['./perfil-about.component.css']
})
export class PerfilAboutComponent implements OnInit {
  formPerfil:FormGroup;
  persona: Persona;
  personas: Persona[] = [];

  constructor(private fb:FormBuilder,
              private perfilAboutService: PerfilAboutService,
              private tokenService: TokenService) { 
                this.formPerfil = this.fb.group({
                  nombre: ['', [Validators.required,Validators.maxLength(50)]],
                  apellido: ['', [Validators.required,Validators.maxLength(50)]],
                  domicilio: ['',[Validators.required,Validators.maxLength(100)]],
                  email: ['', [Validators.required,Validators.maxLength(250)]],
                  titulo: ['', [Validators.required,Validators.maxLength(70)]],
                  aboutMe: ['', [Validators.required, Validators.maxLength(250)]],
                  fotoPerfil: ['', [Validators.required, Validators.maxLength(250)]],
                })
              }

              isLogged = false;

  ngOnInit(): void {
    this.getPerfil();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }

  actualizarPerfil(id:number){
    this.perfilAboutService.getPersonaId(id).subscribe(data=>{
      console.log(id);
      this.persona = data;
      this.formPerfil.patchValue({
        nombre: data.nombre,
        apellido: data.apellido,
        domicilio: data.domicilio,
        email: data.email,
        titulo: data.titulo,
        aboutMe: data.aboutMe,
        fotoPerfil: data.fotoPerfil
      })
    })
  }
  getPerfil(){
    this.perfilAboutService.getPersona().subscribe({
      next:(Response:Persona) =>{
        this.persona=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  editPerfil(){
    this.perfilAboutService.editPersona(this.persona.idUser, this.formPerfil.value).subscribe({
      next:(response: Persona)=>{
        console.log(response);
        this.getPerfil();
        this.formPerfil.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message)
      }
    })
}

}

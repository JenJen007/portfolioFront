import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Experiencia } from 'src/app/models/experiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  formExp : FormGroup;
  experiencia: Experiencia;
  experiencias: Experiencia[] = [];
  
  constructor(private fb:FormBuilder,
               private experienciaService: ExperienciaService,
               private tokenService: TokenService) { 
                this.formExp = this.fb.group({
                  nameExp: ['', [Validators.required,Validators.maxLength(50)]],
                  cargoExp: ['', [Validators.required,Validators.maxLength(50)]],
                  logrosExp: ['', [Validators.required,Validators.maxLength(1500)]],
                  imgExp: ['', [Validators.required,Validators.maxLength(250)]],
                  fechaExpIni: ['', [Validators.required,Validators.maxLength(4)]],
                  fechaExpFin: ['', [Validators.required, Validators.maxLength(4)]],
                })
               }
               isLogged = false;
  ngOnInit(): void {
    this.getAllExp();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }

  actualizarExp(id:number){
    this.experienciaService.getExpId(id).subscribe(data=>{
      console.log(id);
      this.experiencia = data;
      this.formExp.patchValue({
        nameExp: data.nameExp,
        cargoExp: data.cargoExp,
        logrosExp: data.logrosExp,
        imgExp: data.imgExp,
        fechaExpIni: data.fechaExpIni,
        fechaExpFin: data.fechaExpFin
      })
    })
  }

  getAllExp(){
    this.experienciaService.getExperiencia().subscribe({
      next:(Response:Experiencia[]) =>{
        this.experiencias=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  borrarExp(id:number):void{
    console.log(id);
    this.experienciaService.deleteExp(id).subscribe({
      next:(response: void)=>{
        console.log(response);
        this.getAllExp();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message)
      }
    })
  }

  agregarExp(){
    console.log(this.formExp);
    this.experiencia == undefined;
    const experiencia: Experiencia =  this.formExp.value;
    this.experienciaService.createExp(this.formExp.value).subscribe({
      next: (response:Experiencia) =>{
        console.log(response);
        this.getAllExp();
        this.formExp.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        this.formExp.reset();
      }
    })
  }

  editExperiencia(){
      this.experienciaService.editExp(this.experiencia.idExp, this.formExp.value).subscribe({
        next:(response: Experiencia)=>{
          console.log(response);
          this.getAllExp();
          this.formExp.reset();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message)
        }
      })
  }

}

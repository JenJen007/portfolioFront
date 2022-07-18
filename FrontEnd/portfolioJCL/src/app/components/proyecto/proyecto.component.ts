import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Proyecto } from 'src/app/models/proyecto';
import { ProyectoService } from 'src/app/services/proyecto.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {

  formProy : FormGroup;
  proyecto: Proyecto;
  proyectos: Proyecto[] = [];

  constructor(private fb:FormBuilder,
              private proyectoService: ProyectoService,
              private tokenService: TokenService) {
                this.formProy = this.fb.group({
                  nameProye: ['', [Validators.required,Validators.maxLength(50)]],
                  descripProye: ['', [Validators.required,Validators.maxLength(500)]],
                  imgProye: ['', [Validators.required,Validators.maxLength(250)]],
                  enlaceProye: ['', [Validators.required,Validators.maxLength(250)]],
                  fechaProye: ['', [Validators.required, Validators.maxLength(4)]],
                })
               }
               isLogged = false;
  ngOnInit(): void {
    this.getAllProye();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }

  actualizarProye(id:number){
    this.proyectoService.getProyeId(id).subscribe(data=>{
      console.log(id);
      this.proyecto = data;
      this.formProy.patchValue({
        nameProye: data.nameProye,
        descripProye: data.descripProye,
        imgProye: data.imgProye,
        enlaceProye: data.enlaceProye,
        fechaProye: data.fechaProye
      })
    })
  }

  getAllProye(){
    this.proyectoService.getProyecto().subscribe({
      next:(Response:Proyecto[]) =>{
        this.proyectos=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  borrarProye(id:number):void{
    console.log(id);
    this.proyectoService.deleteProye(id).subscribe({
      next:(response: void)=>{
        console.log(response);
        this.getAllProye();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message)
      }
    })
  }

  agregarProye(){
    console.log(this.formProy);
    this.proyecto == undefined;
    const proyecto: Proyecto =  this.formProy.value;
    this.proyectoService.createProye(this.formProy.value).subscribe({
      next: (response:Proyecto) =>{
        console.log(response);
        this.getAllProye();
        this.formProy.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        this.formProy.reset();
      }
    })
  }

  editProyecto(){
      this.proyectoService.editProye(this.proyecto.idProye, this.formProy.value).subscribe({
        next:(response: Proyecto)=>{
          console.log(response);
          this.getAllProye();
          this.formProy.reset();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message)
        }
      })
  }

}

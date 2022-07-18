import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Educacion } from 'src/app/models/educacion';
import { EducacionService } from 'src/app/services/educacion.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {

  formEdu : FormGroup;
  educacion: Educacion;
  educaciones: Educacion[] = [];

  constructor(private fb:FormBuilder,
              private educacionService: EducacionService,
              private tokenService: TokenService) { 
                this.formEdu = this.fb.group({
                  nameEdu: ['', [Validators.required,Validators.maxLength(50)]],
                  titleEdu: ['', [Validators.required,Validators.maxLength(50)]],
                  imgEdu: ['', [Validators.required,Validators.maxLength(250)]],
                  fechaEduIni: ['', [Validators.required,Validators.maxLength(4)]],
                  fechaEduFin: ['', [Validators.required, Validators.maxLength(4)]],
                })
              }
              isLogged = false;
  ngOnInit(): void {
    this.getAllEdu();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }

  actualizarEdu(id:number){
    this.educacionService.getEduId(id).subscribe(data=>{
      console.log(id);
      this.educacion = data;
      this.formEdu.patchValue({
        nameEdu: data.nameEdu,
        titleEdu: data.titleEdu,
        imgEdu: data.imgEdu,
        fechaEduIni: data.fechaEduIni,
        fechaEduFin: data.fechaEduFin
      })
    })
  }

  getAllEdu(){
    this.educacionService.getEducacion().subscribe({
      next:(Response:Educacion[]) =>{
        this.educaciones=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  borrarEdu(id:number):void{
    console.log(id);
    this.educacionService.deleteEdu(id).subscribe({
      next:(response: void)=>{
        console.log(response);
        this.getAllEdu();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message)
      }
    })
  }

  agregarEdu(){
    console.log(this.formEdu);
    this.educacion == undefined;
    const educacion: Educacion =  this.formEdu.value;
    this.educacionService.createEdu(this.formEdu.value).subscribe({
      next: (response:Educacion) =>{
        console.log(response);
        this.getAllEdu();
        this.formEdu.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        this.formEdu.reset();
      }
    })
  }

  editEducacion(){
      this.educacionService.editEdu(this.educacion.idEdu, this.formEdu.value).subscribe({
        next:(response: Educacion)=>{
          console.log(response);
          this.getAllEdu();
          this.formEdu.reset();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message)
        }
      })
  }


}

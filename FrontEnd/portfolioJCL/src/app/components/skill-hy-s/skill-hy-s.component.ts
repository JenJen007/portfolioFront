import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Skill } from 'src/app/models/skill';
import { SkillService } from 'src/app/services/skill.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-skill-hy-s',
  templateUrl: './skill-hy-s.component.html',
  styleUrls: ['./skill-hy-s.component.css']
})
export class SkillHySComponent implements OnInit {

  formSk : FormGroup;
  skill: Skill;
  skills: Skill[] = [];

  constructor(private fb:FormBuilder,
              private skillService:SkillService,
              private tokenService: TokenService) {
                this.formSk = this.fb.group({
                  imgSkill: ['', [Validators.required,Validators.maxLength(250)]],
                  porcentaje: ['', [Validators.required,Validators.maxLength(3)]]
                })
               }
               isLogged = false;
  ngOnInit(): void {
    this.getAllSkill();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }
  actualizarSkill(id:number){
    this.skillService.getSkillId(id).subscribe(data=>{
      console.log(id);
      this.skill = data;
      this.formSk.patchValue({
        imgSkill: data.imgSkill,
        porcentaje: data.porcentaje
      })
    })
  }

  getAllSkill(){
    this.skillService.getSkill().subscribe({
      next:(Response:Skill[]) =>{
        this.skills=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  borrarSkill(id:number):void{
    console.log(id);
    this.skillService.deleteSkill(id).subscribe({
      next:(response: void)=>{
        console.log(response);
        this.getAllSkill();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message)
      }
    })
  }

  agregarSkill(){
    console.log(this.formSk);
    this.skill == undefined;
    const skill: Skill =  this.formSk.value;
    this.skillService.createSkill(this.formSk.value).subscribe({
      next: (response:Skill) =>{
        console.log(response);
        this.getAllSkill();
        this.formSk.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        this.formSk.reset();
      }
    })
  }

  editarSkill(){
      this.skillService.editSkill(this.skill.idSkill, this.formSk.value).subscribe({
        next:(response: Skill)=>{
          console.log(response);
          this.getAllSkill();
          this.formSk.reset();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message)
        }
      })
  }

}

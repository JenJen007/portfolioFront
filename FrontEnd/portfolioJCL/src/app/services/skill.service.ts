import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skill } from '../models/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getSkill():Observable<Skill[]>{
    return this.http.get<Skill[]>(`${this.apiUrl}/skills`);
  }

  public getSkillId(id:number):Observable<Skill>{
    return this.http.get<Skill>(`${this.apiUrl}/skills/${id}`);
  }

  public createSkill(skill: Skill):Observable<Skill>{
    return this.http.post<Skill>(`${this.apiUrl}/skills/nueva`, skill);
  }

  public editSkill(id:number,skill:Skill):Observable<Skill>{
    return this.http.put<Skill>(`${this.apiUrl}/skills/${id}`, skill);
  }

  public deleteSkill(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/skills/${id}`);
  }

}

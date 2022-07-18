import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../models/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getEducacion():Observable<Educacion[]>{
    return this.http.get<Educacion[]>(`${this.apiUrl}/educaciones`);
  }

  public getEduId(id:number):Observable<Educacion>{
    return this.http.get<Educacion>(`${this.apiUrl}/educaciones/${id}`);
  }

  public createEdu(educacion: Educacion):Observable<Educacion>{
    return this.http.post<Educacion>(`${this.apiUrl}/educaciones/nueva`, educacion);
  }

  public editEdu(id:number,educacion:Educacion):Observable<Educacion>{
    return this.http.put<Educacion>(`${this.apiUrl}/educaciones/${id}`, educacion);
  }

  public deleteEdu(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/educaciones/${id}`);
  }
  
}

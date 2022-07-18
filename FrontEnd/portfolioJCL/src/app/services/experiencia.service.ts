import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experiencia } from '../models/experiencia';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getExperiencia():Observable<Experiencia[]>{
    return this.http.get<Experiencia[]>(`${this.apiUrl}/experiencias`);
  }

  public getExpId(id:number):Observable<Experiencia>{
    return this.http.get<Experiencia>(`${this.apiUrl}/experiencias/${id}`);
  }

  public createExp(experiencia: Experiencia):Observable<Experiencia>{
    return this.http.post<Experiencia>(`${this.apiUrl}/experiencias/nueva`, experiencia);
  }

  public editExp(id:number,experiencia:Experiencia):Observable<Experiencia>{
    return this.http.put<Experiencia>(`${this.apiUrl}/experiencias/${id}`, experiencia);
  }

  public deleteExp(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/experiencias/${id}`);
  }
  
}

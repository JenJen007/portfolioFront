import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../models/persona';

@Injectable({
  providedIn: 'root'
})
export class PerfilAboutService {
  
  private apiUrl = 'https://portfoliojennifercontreras.herokuapp.com/api';

  constructor(private http: HttpClient) { }

  public getPersona():Observable<Persona>{
    return this.http.get<Persona>(`${this.apiUrl}/personas/1`);
  }

  public getPersonaId(id:number):Observable<Persona>{
    return this.http.get<Persona>(`${this.apiUrl}/personas/${id}`);
  }

  public createPersona(persona: Persona):Observable<Persona>{
    return this.http.post<Persona>(`${this.apiUrl}/personas/nueva`, persona);
  }

  public editPersona(id:number,persona:Persona):Observable<Persona>{
    return this.http.put<Persona>(`${this.apiUrl}/personas/${id}`, persona);
  }

  public deletePersona(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/personas/${id}`);
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../models/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  private apiUrl = 'https://portfoliojennifercontreras.herokuapp.com/api';

  constructor(private http: HttpClient) { }

  public getProyecto():Observable<Proyecto[]>{
    return this.http.get<Proyecto[]>(`${this.apiUrl}/proyectos`);
  }

  public getProyeId(id:number):Observable<Proyecto>{
    return this.http.get<Proyecto>(`${this.apiUrl}/proyectos/${id}`);
  }

  public createProye(proyecto: Proyecto):Observable<Proyecto>{
    return this.http.post<Proyecto>(`${this.apiUrl}/proyectos/nuevo`, proyecto);
  }

  public editProye(id:number,proyecto:Proyecto):Observable<Proyecto>{
    return this.http.put<Proyecto>(`${this.apiUrl}/proyectos/${id}`, proyecto);
  }

  public deleteProye(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/proyectos/${id}`);
  }

}

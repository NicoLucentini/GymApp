import { Injectable } from '@angular/core';
import { Usuario } from './usuario';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosMgrService {


  constructor(private http:HttpClient) { }

  public add(user : Usuario){
    console.log(user);
    return this.http.post("http://localhost:8090/gym/usuarios/add", user,{responseType:'text' as 'json'});
  }
  public login(user : Usuario){
    return this.http.post("http://localhost:8090/gym/usuarios/login", user,{responseType:'text' as 'json'});
  }
  public list(){
    return this.http.get("http://localhost:8090/gym/usuarios/getAll");
  }
  public listAlumnos(){
    return this.http.get("http://localhost:8090/gym/usuarios/getAlumnos");
  }
  public listProfesores(){
    return this.http.get("http://localhost:8080/gym/usuarios/getProfesores");
  }
  public remove(id){
    return this.http.get("http://localhost:8080/gym/usuarios/remove/"+id);
  }
}

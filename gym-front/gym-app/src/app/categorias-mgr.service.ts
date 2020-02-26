import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Categoria } from './categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriasMgrService {

  constructor(private http:HttpClient) { }

  public doRegister(cat : Categoria){
    console.log(cat);
    return this.http.post("http://localhost:8090/gym/categorias/add", cat,{responseType:'text' as 'json'});
  }
  public list(){
    return this.http.get("http://localhost:8090/gym/categorias/getAll");
  }
  public remove(id){
    return this.http.get("http://localhost:8090/gym/categorias/remove/"+id);
  }

}

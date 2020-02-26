import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClasesMgrService {

  constructor(private http:HttpClient) { }

  public list(){
    return this.http.get("http://localhost:8080/gym/clases/getAll");
  }
}

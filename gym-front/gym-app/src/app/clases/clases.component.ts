import { Component, OnInit } from '@angular/core';
import {Clase} from '../clase';import { ClasesMgrService } from '../clases-mgr.service';
;

@Component({
  selector: 'app-clases',
  templateUrl: './clases.component.html',
  styleUrls: ['./clases.component.css']
})
export class ClasesComponent implements OnInit {

  clase : Clase = new Clase("",null,null,null,null); 
  clases : any;
  constructor(private service:ClasesMgrService) { }

  ngOnInit() {
    this.getAll();
  }
  public getAll(){
    let resp=this.service.list();
    console.log(resp);
    resp.subscribe((data)=>this.clases=data);
  }
}

import { Component, OnInit } from '@angular/core';
import { CategoriasMgrService } from '../categorias-mgr.service';
import { Categoria } from '../categoria';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

cat : Categoria = new Categoria("",""); 
cats : any;
message: any;
  constructor(private service:CategoriasMgrService) { }

  ngOnInit() {
   this.getAll();
  }

  public doRegister(){
    let res  =  this.service.doRegister(this.cat);
    res.subscribe((data)=> this.message = data);
  }
  public getAll(){
    let resp=this.service.list();
    resp.subscribe((data)=>this.cats=data);
  }
  public remove(id:number){
    let resp= this.service.remove(id);
    resp.subscribe((data)=>this.cats=data);

    //actualizo
    this.getAll();
   }
}

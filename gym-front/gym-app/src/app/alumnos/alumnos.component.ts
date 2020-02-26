import { Component, OnInit } from '@angular/core';
import { UsuariosMgrService } from '../usuarios-mgr.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.css']
})
export class AlumnosComponent implements OnInit {

  
  usuario : Usuario = new Usuario(0,"","","","", 2); 
  usuarios : any;
  constructor(private service:UsuariosMgrService) { }

  ngOnInit() {
    this.getAll();
   }
 
  public getAll(){
    let resp=this.service.listAlumnos();
    resp.subscribe((data)=>this.usuarios=data);
  }
   public registrarAlumno(){
    let res  =  this.service.add(this.usuario);
    res.subscribe((data)=>{this.usuarios=data;
      this.getAll();
    });
  }
  public remove(id:number){
    let resp= this.service.remove(id);
    resp.subscribe( (data)=> {this.usuarios=data;
      this.getAll();});
   }

}

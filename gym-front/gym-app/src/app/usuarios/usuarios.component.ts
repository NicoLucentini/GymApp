import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import { UsuariosMgrService } from '../usuarios-mgr.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  usuario : Usuario = new Usuario(0,"","","","", 2); 
  usuarios : any;
  usuarioOpciones : ["Alumno", "Profesor"];
  constructor(private service:UsuariosMgrService) { }

  ngOnInit() {
    this.getAll();
   }
 
   public registrarUsuario(){
    let res  =  this.service.add(this.usuario);
    console.log(res);
    res.subscribe((data)=>{
      this.usuario = data;
    });
  }
  public getAll(){
    let resp=this.service.list();
    resp.subscribe((data)=>this.usuarios=data);
  }
  public getAlumnos(){
    let resp=this.service.listAlumnos();
    resp.subscribe((data)=>this.usuarios=data);
  }
  public getProfesores(){
    let resp=this.service.listProfesores();
    resp.subscribe((data)=>this.usuarios=data);
  }
  public remove(id:number){
    let resp= this.service.remove(id);
    resp.subscribe( (data)=> {this.usuarios=data;
      this.getAll();});
   }

}

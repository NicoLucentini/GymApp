import { Component, OnInit } from '@angular/core';
import { UsuariosMgrService } from '../usuarios-mgr.service';
import { Usuario } from '../usuario';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  usuario : Usuario = new Usuario(0,"","","","", 2); 
  usuarioLogin : Usuario = new Usuario(0,"","","","", 2); 
  usuarioOpciones : ["Alumno", "Profesor", "Adminstrador"];

  constructor(private usuarioService:UsuariosMgrService, private  http:HttpClient) { }
  messageRegistro : String;
  messageLogin : String;

  ngOnInit() {
  }

  public registrarUsuario(){
    let res  =  this.usuarioService.add(this.usuario);
    res.subscribe((data)=>{
      if(data == "")
      {
        this.messageRegistro = "Email ya registrado";
      } 
      else
      {
      this.usuario=new Usuario(0,"","","","", 2); 
      }
    });
  }
  public login(){
    let res  =  this.usuarioService.login(this.usuarioLogin);
    res.subscribe((data)=>{
      if(data == "")
      {
        this.messageLogin = "Usuario y/o Contraseña incorrectos";
      } 
      else
      {
        this.usuarioLogin=data;       
      }
    });
  }
}

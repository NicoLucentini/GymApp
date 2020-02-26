import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriasComponent } from './categorias/categorias.component';
import { ClasesComponent } from './clases/clases.component';
import { AlumnosComponent } from './alumnos/alumnos.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { InicioComponent } from './inicio/inicio.component';
import { MenuComponent } from './menu/menu.component';


const routes: Routes = [
{path:"",redirectTo:"menu",pathMatch:"full"},
{path:"categorias", component :CategoriasComponent },
{path:"clases", component :ClasesComponent },
{path:"alumnos", component :AlumnosComponent },
{path:"usuarios", component :UsuariosComponent },
{path:"menu", component :MenuComponent },
{path:"inicio", component :InicioComponent }
//{path: "alumnos:id", component : AlumnosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

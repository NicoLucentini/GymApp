import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { CategoriasMgrService } from './categorias-mgr.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { ClasesComponent } from './clases/clases.component';
import { ClasesMgrService } from './clases-mgr.service';
import { AlumnosComponent } from './alumnos/alumnos.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { UsuariosMgrService } from './usuarios-mgr.service';
import { InicioComponent } from './inicio/inicio.component';
import { InicioMgrService } from './inicio-mgr.service';
import { MenuComponent } from './menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoriasComponent,
    ClasesComponent,
    AlumnosComponent,
    UsuariosComponent,
    InicioComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [CategoriasMgrService,ClasesMgrService, UsuariosMgrService, InicioMgrService],
  bootstrap: [AppComponent]
})
export class AppModule { }

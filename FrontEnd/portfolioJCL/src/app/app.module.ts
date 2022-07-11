import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { NgCircleProgressModule } from 'ng-circle-progress';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { BannerComponent } from './components/banner/banner.component';
import { PerfilAboutComponent } from './components/perfil-about/perfil-about.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { SkillHySComponent } from './components/skill-hy-s/skill-hy-s.component';
import { DragDropComponent } from './components/drag-drop/drag-drop.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BannerComponent,
    PerfilAboutComponent,
    ExperienciaComponent,
    EducacionComponent,
    ProyectoComponent,
    SkillHySComponent,
    DragDropComponent,
    FooterComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgCircleProgressModule.forRoot({
      radius: 100,
      outerStrokeWidth: 12,
      outerStrokeColor: "#e4002b",
      showInnerStroke: false,
      animationDuration: 600,
      showUnits: false,
      showSubtitle: false,
      showImage: true,
      imageHeight: 150,
      imageWidth: 150

    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

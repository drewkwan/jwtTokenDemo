import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import { UserComponent } from './components/user.component';
import { AdminComponent } from './components/admin.component';
import { LoginComponent } from './components/login.component';
import { HeaderComponent } from './components/header.component';
import { ForbiddenComponent } from './components/forbidden.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';

const appRoutes: Routes =[
  {path: '', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent}
]


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserComponent,
    AdminComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

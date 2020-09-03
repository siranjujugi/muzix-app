import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './components/register/register.component';
import { AngularmaterialModule } from '../angularmaterial/angularmaterial.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { LoginComponent } from './components/login/login.component';


@NgModule({
  declarations: [RegisterComponent, LoginComponent],
  imports: [
    CommonModule, AngularmaterialModule, AppRoutingModule
  ], 
  exports : [
    AngularmaterialModule, AppRoutingModule
  ]
})
export class AuthenticationModule { }

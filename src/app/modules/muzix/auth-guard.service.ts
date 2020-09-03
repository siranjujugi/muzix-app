import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router/src/interfaces';
import { AuthenticationService } from '../authentication/authentication.service';
import { Router } from '@angular/router';
import { User } from '../authentication/User';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  
  // path: import("@angular/router").ActivatedRouteSnapshot[];
 
  // route: import("@angular/router").ActivatedRouteSnapshot;

  canActivate(): boolean {
    if( this.authenticationService.isTokenExpired() ){
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
  

  constructor(private authenticationService : AuthenticationService, private router : Router) {
  }
}

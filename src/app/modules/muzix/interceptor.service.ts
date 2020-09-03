import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';

import { Observable } from 'rxjs';
import { AuthenticationModule } from '../authentication/authentication.module';
import { AuthenticationService } from '../authentication/authentication.service';


@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log('In intercept');

    request = request.clone({
      setHeaders : {
        Authorization : `Bearer ${this.authenticationService.getToken()}`
      }
    });
    //throw new Error("Method not implemented.");
    return next.handle(request);
  }

  constructor(private authenticationService : AuthenticationService) { 

  }
}

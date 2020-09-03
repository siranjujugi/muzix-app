import { Component, OnInit } from '@angular/core';
import { User } from '../../User';
import { AuthenticationService } from '../../authentication.service';
import { MatSnackBar } from '@angular/material';
import { Route } from '@angular/compiler/src/core';
import { RouteConfigLoadEnd, Router } from '@angular/router';
export const TOKEN = 'token';
// export const USER_NAME = "username";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user : User;
  constructor(private authenticationService: AuthenticationService, private snackBar: MatSnackBar, private router: Router) { 
    this.user = new User();
  }

  login() {
    this.authenticationService.loginUser(this.user).subscribe(response => {
      console.log(response);
      if (response) {
        console.log("token ",  response.body["token"] );
        localStorage.setItem(TOKEN, response.body["token"]);
        this.snackBar.open( response.body["message"], " " , {
          duration : 1000
        }
        );
        this.router.navigate(["/Germany"]);
      }
    }, error => {
      console.log("Error ", error);
      if  (error.status == 404) {
        const errorMsg = error.error.message;
        this.snackBar.open( errorMsg, " " , {
          duration : 1000
        });
      }
    });
  }

  ngOnInit() {
  }

}

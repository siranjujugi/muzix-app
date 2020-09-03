import { Component, OnInit } from '@angular/core';
import { User } from '../../User';
import { AuthenticationService } from '../../authentication.service';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;

  constructor(private authenticationService: AuthenticationService, private snackBar: MatSnackBar, private router: Router) {
    this.user = new User();
  }

  register() {

    this.authenticationService.registerUser(this.user).subscribe(response => {
      if (response.status == 201) {
        this.snackBar.open("User registered successfully", " ", {
          duration: 1000
        });
        // this.authenticationService.saveUser(this.user).subscribe(response => {
        //   console.log("Saved User ", response);
        // })
      }
      this.router.navigate(["/login"]);
    }, error => {
      if (error.status == 409) {
        const errorMsg = error.error.message;
        this.snackBar.open(errorMsg, " ", {
          duration: 1000
        })
      }
    }
    )
  }

  ngOnInit() {
  }

}

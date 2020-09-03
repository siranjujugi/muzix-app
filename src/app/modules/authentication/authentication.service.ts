import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './User';
// import { TOKEN } from './components/login/login.component';
export const USER_NAME = "username";
export const TOKEN = "token";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private userEndpoint: string;
  private authEndpoint: string;
  constructor(private httpClient: HttpClient) {
    // this.userEndpoint = "http://localhost:8085/api/v1/usertrackservice/";

    this.userEndpoint = "http://localhost:8089/usertrackservice/api/v1/usertrackservice/register";
    this.authEndpoint = "http://localhost:8089/authenticationservice/api/v1/userservice/";

  }

  registerUser(newUser: User) {
    const url = this.userEndpoint;
    return this.httpClient.post(url, newUser, { observe: "response" });

  }
  // saveUser(newUser: User) {
  //   const url = this.authEndpoint + "save";
  //   return this.httpClient.post(url, newUser);
  // }

  loginUser(newUser: User) {
    const url = this.authEndpoint + "login";
    sessionStorage.setItem(USER_NAME , newUser.userName);
    return this.httpClient.post(url, newUser, { observe: "response" });
  }

  getToken() {
    return localStorage.getItem(TOKEN);
  }

  isTokenExpired(token? : string){
    return (localStorage.getItem(TOKEN)) ? true : false;
  }

  logOut(){
    sessionStorage.removeItem(USER_NAME);
    sessionStorage.clear;
    localStorage.removeItem(TOKEN);
    sessionStorage.clear;
    console.log('logOut');

  }
}

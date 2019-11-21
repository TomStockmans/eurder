import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import axios from 'axios';
import { promise } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  apiUrl : string = 'http://localhost:8080/users';
  apiAuthenticateUrl : string = 'http://localhost:8080';

  async addUser (user : User) : Promise<any> {
    const response = await axios.post(this.apiUrl, user).then(response => {
      if(response.status == 201){
        return response.data;
      }
    });

    if(response) return response;
  }

  async login (username, password) : Promise<any> {
    const response = await axios.get(this.apiAuthenticateUrl+ "/authenticate?username=" + username + "&password=" + password).then(response => {
      //alert(response.status)
      if(response.status == 200){
        localStorage.setItem("role", response.headers.role);
        localStorage.setItem("token", response.headers.authorization);
        return response.headers;
      }
    });

    if(response) {return response};
  }

}

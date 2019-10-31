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

  async addUser (user : User) : Promise<any> {
    const response = await axios.post(this.apiUrl, user).then(response => {
      if(response.status == 201){
        return response.data;
      }
    });

    if(response) return response;
  }

}

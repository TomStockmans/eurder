import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import Axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient){

  }
  
  private apiUrl : string = 'http://localhost:8080/users';
  private apiAuthenticateUrl : string = 'http://localhost:8080';

  addUser (user : User) : Observable<any> {

    return this.http.post<any>(this.apiUrl, user, {});
  }

   async login (username, password) : Promise<any> {
     const response = await Axios.get(this.apiAuthenticateUrl+ "/authenticate?username=" + username + "&password=" + password).then(response => {
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

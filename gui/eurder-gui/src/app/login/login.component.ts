import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  username : string;
  password : string;

  constructor(private router: Router, private userservice: UserService){

  }


  async login(){
     var succes = await this.userservice.login(this.username, this.password);
     if(localStorage.getItem('token') != 'undefined'){
       this.router.navigate(['/']);
     }

  }

  ngOnInit() {
  }

}

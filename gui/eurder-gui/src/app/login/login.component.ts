import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username : string;
  password : string;
  userservice = new UserService();
  constructor() { }

  login(){
    this.userservice.login(this.username, this.password);
  }

  ngOnInit() {
  }

}

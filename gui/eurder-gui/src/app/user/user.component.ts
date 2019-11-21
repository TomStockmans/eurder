import { Component, OnInit, Input } from '@angular/core';
import {User} from '../user';
import { UserService } from '../user.service';
import { Alert } from 'selenium-webdriver';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  @Input() user = new User();
  addedUser: any;
  
  constructor(private userService: UserService) { 

  }
  
  addUser() : void {
    //alert(JSON.stringify(this.user))
    this.userService.addUser(this.user).subscribe(resp => this.addedUser = resp);
  };


  ngOnInit() {

  }

}

import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Classes/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{
  user:User=new User();
 username!:String;

  constructor(private login: LoginService){}

  ngOnInit(): void {
    
    this.user = this.login.getUser(); 
  }

}

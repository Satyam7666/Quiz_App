import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/Classes/user';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
 user:User=new User();
 username!:String;

  constructor(private login: LoginService,private route:ActivatedRoute,private _userservice:UserService){}

  ngOnInit(): void {
    
    this.user = this.login.getUser(); 
  }

  

}

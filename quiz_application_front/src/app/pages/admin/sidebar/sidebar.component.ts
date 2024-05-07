import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Classes/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  user:User=new User();

  constructor(private login: LoginService){}

  ngOnInit(): void {
    this.user = this.login.getUser(); 
  }

}

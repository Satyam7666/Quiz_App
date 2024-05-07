import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Category } from 'src/app/Classes/category';
import { User } from 'src/app/Classes/user';
import { CategoryService } from 'src/app/services/category.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-usersidebar',
  templateUrl: './usersidebar.component.html',
  styleUrls: ['./usersidebar.component.css']
})
export class UsersidebarComponent implements OnInit {

  user:User=new User();

  

  
  categories!:Category[];

  constructor(private _cat : CategoryService, private _snak:MatSnackBar,private login: LoginService){}


  ngOnInit(): void{
    this.user = this.login.getUser(); 
    this._cat.getcategories().subscribe(
      (data: any)=>{
        this.categories=data;
      },
      (error)=>{
        this._snak.open('Error in loading categories from server','',{
          duration:3000,
        });
      }
    );
  }

}

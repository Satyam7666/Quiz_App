import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  loginData={
    userName:'',
    password:''
  }

  constructor(private snack:MatSnackBar,private login:LoginService,private router:Router){ }
  ngOnInit(): void {
    
  }
  formSubmit(){
    console.log("login button click");
    if(this.loginData.userName.trim()=='' ||
    this.loginData.userName==null  ){
      this.snack.open('Username is requried !!','',{
        duration:3000,
      });
      return;
    }

    

    if(this.loginData.password.trim()=='' ||
    this.loginData.password==null){
      this.snack.open('Password is requried !!','',{
        duration:3000,
      });
      return;
    }


    ///request to server to generate token
    this.login.generateToken(this.loginData).subscribe(
      (data: any)=>{
        console.log('success');
        console.log(data);

        //login
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe(
          (user : any)=>{
            this.login.setUser(user);
            console.log(user);

            //redirect ADMIN->admin dashboard
            //Normal-.normal dashboard

            if(this.login.getUserRole()=='ADMIN')
            {
              //admin dashboard
           //   window.location.href='/admin';
           this.router.navigate(['admin']);
           this.login.loginStatusSubject.next(true);
            }else if(this.login.getUserRole()=='NORMAL'){
              //nomal-user
             // window.location.href='/user-dashboard'
             this.router.navigate(['/user-dashboard']);
             this.login.loginStatusSubject.next(true);

            }else{
              this.login.logout();

            }
          }
        );
      },
      (error)=>{
        console.log('Error !');
        console.log(error);
        this.snack.open('Invalid username or password. Please try again.', '', {
          duration: 3000,
        });
        
      }
        );
      }

}

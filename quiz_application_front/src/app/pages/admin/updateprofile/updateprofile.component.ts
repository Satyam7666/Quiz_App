import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { User } from 'src/app/Classes/user';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit{
  user:User=new User();

  constructor(private userService:UserService, private snack:MatSnackBar,private login: LoginService,private router:Router){}
  ngOnInit(): void {
    this.user = this.login.getUser();
  }
  

  formSubmit(){
    console.log(this.user)
    console.log(this.user.userId)
      
      this.userService.updateUser(this.user.userId,this.user).subscribe(
        (data : any)=>{
          //success
          console.log('inside')
          console.log(data.userId)
          console.log(data)
          //alert('success')
          Swal.fire('User detail Succesfully updated', '','success');
          this.router.navigate(['/admin/profile/' + this.user.username]);

        },
        (error)=>{
          //error
          console.log(error);
          //alert('Someting wnt wrong')
          this.snack.open('Something went wrong',' ',{
            duration:3000
          })
          
        },
        )
      
    };

submit(){
  this.formSubmit()
  
}
}

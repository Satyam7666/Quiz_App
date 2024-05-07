import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from 'src/app/Classes/user';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
user:User=new User();

  constructor(private userService:UserService, private snack:MatSnackBar){}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  formSubmit(){
   
      //add user : userService
      this.userService.addUser(this.user).subscribe(
        (data : any)=>{
          //success
          console.log(data)
          //alert('success')
          Swal.fire('Succesfully register', '','success');

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

}

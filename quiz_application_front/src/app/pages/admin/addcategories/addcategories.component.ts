import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Category } from 'src/app/Classes/category';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addcategories',
  templateUrl: './addcategories.component.html',
  styleUrls: ['./addcategories.component.css']
})
export class AddcategoriesComponent {

  category:Category=new Category();
  constructor(private _category:CategoryService,private _snack: MatSnackBar,private router:Router){}


  formSubmit(){
    if(this.category.title.trim()== '' || this.category.title==null){
      this._snack.open('Title Required !!','',{
        duration:3000,
      });
      return ;
    }
    // all done now add
    this._category.addCategory(this.category).subscribe(
      (data: any) =>{
        this.category.title=''
        this.category.description=''
        Swal.fire('Success!!','Category is added successfuly','success');
        this.router.navigate(['/admin/view-category'])
      },
      (error) =>{
        console.log(error);
        Swal.fire('Error !!','Server error','error');
      }
    )
  }

}

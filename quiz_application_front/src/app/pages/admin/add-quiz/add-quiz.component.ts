import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Category } from 'src/app/Classes/category';
import { Quiz } from 'src/app/Classes/quiz';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {
  categories!:Category[];

  quizData:Quiz=new Quiz();

  constructor(private _categories: CategoryService,private _snak:MatSnackBar,private _quiz:QuizService,private router:Router){}
  
  ngOnInit(): void {
    this._categories.getcategories().subscribe(
      (data: any)=>{
        this.categories=data;
        console.log(this.categories);
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error !!','Error in loading data','error');
      }
    );
  }
  
  addQuiz(){
    if(this.quizData.title.trim()=='' || this.quizData.title == null){
      this._snak.open('Title requried !!','',{
        duration:3000,
      });
      return;
    }
    //call server
    console.log(this.quizData);
    this._quiz.addQuiz(this.quizData).subscribe((data : any)=>{
        Swal.fire('Success','quiz is added','success')
        this.router.navigate(['/admin/view-quizes']);
      },

    (error)=>{
      Swal.fire('error!!','Error while adding quiz','error')
      console.log(error);
    }
   
  )};


  

}

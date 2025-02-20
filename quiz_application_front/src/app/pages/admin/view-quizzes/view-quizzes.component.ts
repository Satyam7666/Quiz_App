import { Component, OnInit } from '@angular/core';
import { Quiz } from 'src/app/Classes/quiz';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit{
  quizzes!: Quiz[];
quiz:Quiz=new Quiz();

  constructor (private _quiz:QuizService){}

  ngOnInit(): void{
    this._quiz.quizzes().subscribe(
      (data : any) =>{
        this.quizzes=data;
        console.log(this.quizzes);
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error !','Error in loading data !','error');
      }
    );
  }
  deleteQuiz( quizId:Number){
   
Swal.fire({
  icon:'info',
  title:'Are yoy sure ?',
 confirmButtonText:'Delete',
 showCancelButton:true
}).then((result)=>{
  if(result.isConfirmed){
    this._quiz.deleteQuiz(quizId).subscribe(
      (data)=>{
       this.quizzes= this.quizzes.filter((quiz)=> quiz.quizId !=quizId);
        Swal.fire('Success','Quiz Deleted','success');
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error','Error in deleteing quiz','error');
      }
    );
  }
})


  }

}

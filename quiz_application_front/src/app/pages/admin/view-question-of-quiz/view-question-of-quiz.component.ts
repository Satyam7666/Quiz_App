import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { subscribeOn } from 'rxjs';
import { Question } from 'src/app/Classes/question';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-question-of-quiz',
  templateUrl: './view-question-of-quiz.component.html',
  styleUrls: ['./view-question-of-quiz.component.css']
})
export class ViewQuestionOfQuizComponent implements OnInit{
  qId! :number;
  qTitle!:String;

  questions!: Question[];

  constructor(private _route : ActivatedRoute,private _question:QuestionService,private _snack:MatSnackBar){}
  ngOnInit(): void {
    this.qId=this._route.snapshot.params['qId'];
    this.qTitle=this._route.snapshot.params['title'];
    //console.log(this.qId);
    //console.log(this.qTitle);

    this._question.getQuestionOfQuiz(this.qId).subscribe((data :any)=>{
      console.log(data);
      this.questions=data;

    },(error)=>{
      console.log(error);
    })

  }


  deleteQuestion(quesId:Number){
    Swal.fire({
      icon:'info',
      title:'Are yoy sure ?',
     confirmButtonText:'Delete',
     showCancelButton:true
    }).then((result)=>{
      if(result.isConfirmed){
        this._question.deleteQuestion(quesId).subscribe(
          (data)=>{
           this.questions= this.questions.filter((question)=> question.quesId!=quesId);
            Swal.fire('Success','Quiz Deleted','success');
          },
          (error)=>{
            Swal.fire('Error','Error in deleteing quiz','error');
          }
        );
      }
    })
    
  }

}

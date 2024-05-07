import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from 'src/app/Classes/question';
import { Quiz } from 'src/app/Classes/quiz';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  quizId!:number;
  qTitle!:String;
  question:Question=new Question();

  constructor(private _route:ActivatedRoute,private  _question:QuestionService,private router:Router){}
  ngOnInit(): void {
    this.quizId=this._route.snapshot.params['qId'];
    this.qTitle=this._route.snapshot.params['title']
   //console.log(this.qId);
   this.question.quiz.quizId=this.quizId;
  }

  formSubmit(){
    if(this.question.question.trim()=='' || this.question.question==null){
      return;
    }

    if(this.question.option1.trim()=='' || this.question.option1==null){
      return;
    }

    if(this.question.option2.trim()=='' || this.question.option2==null){
      return;
    }

    if(this.question.answer.trim()=='' || this.question.answer==null){
      return;
    }
   console.log(this.question);
    this._question.addQuestion(this.question).subscribe(
      (data)=>{
  
        Swal.fire('Success','Question Added. Add another one','success');
        this.router.navigate(['/admin/view-questions/' + this.quizId + '/' + this.qTitle]);
       
      },
      (error)=>{
        Swal.fire('Error','Error in addinig question','error');
      }
    )
    }
  

  }


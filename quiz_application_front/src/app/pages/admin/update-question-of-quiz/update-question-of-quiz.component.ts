import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from 'src/app/Classes/question';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-question-of-quiz',
  templateUrl: './update-question-of-quiz.component.html',
  styleUrls: ['./update-question-of-quiz.component.css']
})
export class UpdateQuestionOfQuizComponent implements OnInit {

  quizId!:number;
  qTitle!:String;
  quesId!:number;
  question:Question=new Question();
  constructor(private _route:ActivatedRoute,private  _question:QuestionService,private router:Router){}
  ngOnInit(): void {
    this.quizId=this._route.snapshot.params['qId'];
    this.qTitle=this._route.snapshot.params['title']
    this.quesId=this._route.snapshot.params['quesId']
     console.log(this.quesId);
   console.log(this.quizId);
   console.log(this.quesId);
   console.log(this.qTitle);

   this._question.getQuestionById(this.quesId).subscribe(data=>{
  //  console.log(data)
    this.question=data;
    console.log(this.question);
   },error=>console.log(error));
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
   console.log(this.quesId)
    this._question.updateQuestion(this.quesId,this.question).subscribe(
      (data)=>{
  
        Swal.fire('Success','Question updated.','success');
        this.router.navigate(['/admin/view-questions/' + this.quizId + '/' + this.qTitle]);
       
      },
      (error)=>{
        Swal.fire('Error','Error in addinig question','error');
      }
    )
    }
  


}

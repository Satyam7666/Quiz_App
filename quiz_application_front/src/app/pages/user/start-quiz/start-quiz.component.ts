import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Question } from 'src/app/Classes/question';
import { LoginService } from 'src/app/services/login.service';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-start-quiz',
  templateUrl: './start-quiz.component.html',
  styleUrls: ['./start-quiz.component.css']
})
export class StartQuizComponent implements OnInit {
  
  qId:any;
  questions!:Question[];
  isSubmit=false;
 

  marksGot=0;
  correctAnswer=0;
  attempted=0;

  timer:any;


  constructor(private _locationSt:LocationStrategy,private _rote:ActivatedRoute,
    private _question:QuestionService){}

  ngOnInit():void{
    this.preventBackButton();
    this.qId=this._rote.snapshot.params['qid']
  console.log(this.qId)

  this.loadQuestion();
  }

  loadQuestion(){
    this._question.getQuestionOfQuizForTest(this.qId).subscribe(
      (data :any)=>{
        this.questions=data;

        this.timer=this.questions.length * 2 * 60;
        

       
        console.log(this.questions)
        this.startTimer();
      },
      (error)=>{
        console.log(error);
        Swal.fire("Error","error in loading question of the quiz","error");
      }
    )
  }

  preventBackButton(){
    history.pushState(null, '' ,location.href);
    this._locationSt.onPopState(
      ()=>{
        history.pushState(null,'',location.href);
      }
    )
  }

  trackByFn(index: number, item: any): number {
    return index; // Return a unique identifier for each item
  }

  submitQuiz(){
    Swal.fire({
      title:'Do you want to submit the quiz?',
      showCancelButton:true,
      confirmButtonText:'Submit',
      icon:'info',
    }).then((e)=>{
      if(e.isConfirmed){

       this.evalQuiz();
      }
    });
  }

  startTimer(){
    let t :any = window.setInterval(()=>{
      if(this.timer <=0){
        this.evalQuiz();
        clearInterval(t);
      }else{
        this.timer--;
      }
    },1000)
  }
  


  getFormattedTime(){
    let mm=Math.floor(this.timer/60)
    let ss=this.timer-mm*60;
    return `${mm}min :${ss}sec`
  }

  
  evalQuiz(){
   //call to server to check question ********************************************************************

   this._question.evalQuiz(this.questions).subscribe(
    (data:any)=>{
      console.log(data);
      this.marksGot =parseFloat(Number(data.marksGot).toFixed(2));
      this.correctAnswer=data.correctAnswer;
      this.attempted=data.attempted;
     
      this.isSubmit=true;
    },
    (error)=>{
      console.log(error);
    }
   )

    // this.isSubmit=true;
    // this.questions.forEach((q:any)=>{
    //   if(q.givenAnswer==q.answer){
    //     this.correctAnswer++
    //     let marksSingle= this.questions[0].quiz.maxMark/this.questions.length
    //     this.marksGot += marksSingle;
        
    //   }
    //   if(q.givenAnswer.trim()!=''){
    //     this.attempted++;
    //   }
      
      
    // });
    // console.log("correct answer"+this.correctAnswer)
    //   console.log("marks got"+this.marksGot)
    //   console.log("Attempted"+this.attempted)


  }

  printPage(){
    window.print();
  }
}

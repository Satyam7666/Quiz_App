import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Quiz } from 'src/app/Classes/quiz';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-load-quiz',
  templateUrl: './load-quiz.component.html',
  styleUrls: ['./load-quiz.component.css']
})
export class LoadQuizComponent implements OnInit{
  catId!:number;
  quizzess!:Quiz[];

  constructor(private _route:ActivatedRoute,private _quiz:QuizService){}

  ngOnInit(): void{
    
  this._route.params.subscribe((params)=>{
    this.catId=params['catId']

    if(this.catId== 0){
      console.log('Load all quiz');
         this._quiz.getActiveQuizzes().subscribe(
           (data)=>{
             this.quizzess=data;
             console.log('load all quiz')
             console.log(this.quizzess);
           },
           (error)=>{
             console.log(error);
           }
         )
   
       }else{
         console.log('Load specific quiz')
         this._quiz.getActiveQuizzesofCategory(this.catId).subscribe(
          (data :any)=>{
            
            this.quizzess=data;
          },
          (error)=>{
            alert("error in loadiing quiz data")
          }
         )
       }
  })
   

   
  }

}

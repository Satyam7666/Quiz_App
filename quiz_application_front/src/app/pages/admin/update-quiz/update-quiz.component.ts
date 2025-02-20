import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/Classes/category';
import { Quiz } from 'src/app/Classes/quiz';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {
  constructor(private _route:ActivatedRoute,private _quiz:QuizService,private _cat:CategoryService,
    private _router:Router){}
  qId!:number;
   quiz:Quiz=new Quiz();
   categories!:Category[];

  ngOnInit():void{
    this.qId=this._route.snapshot.params['quizId'];
   //alert(this.qId)

   this._quiz.getQuiz(this.qId).subscribe(
    (data:any)=>{
      this.quiz=data;
      console.log(this.quiz);
    },
   (error)=>{
    console.log();
   }
   );
   this._cat.getcategories().subscribe((data :any)=>{
    this.categories=data;
   },error=>{
    alert("error in loading category")
   }
   )


  }

  //update form submit
  public updateData(){


    this._quiz.updateQuiz(this.qId,this.quiz).subscribe((data)=>
    {
      Swal.fire('Updated successfully !!','quiz updated','success').then((e)=>{
        this._router.navigate(['/admin/view-quizes']);
      });
    },
    (error)=>{
      Swal.fire('error !!','error in updating','error');
      console.log(error)
    })

  }

}

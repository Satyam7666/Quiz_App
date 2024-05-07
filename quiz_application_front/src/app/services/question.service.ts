import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Observable } from 'rxjs';
import { Question } from '../Classes/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private _http: HttpClient) { }
  public getQuestionOfQuiz(qId : any){
    return this._http.get(`${baseUrl}/question/quiz/all/${qId}`);

  }

   //add question

   public addQuestion(question :Question):Observable<object>{
    return this._http.post(`${baseUrl}/question/`,question);

  }

   //delete question
   public deleteQuestion(questionId: Number){
    return this._http.delete(`${baseUrl}/question/${questionId}`);

  }

  //
  public getQuestionById(quesId:number):Observable<Question>{
    return this._http.get<Question>(`${baseUrl}/question/${quesId}`);
  }

  public updateQuestion( quesId:number, question :Question):Observable<object>{
    console.log('inside services')
    console.log(quesId);
    console.log(question);
    return this._http.put(`${baseUrl}/question/${quesId}`,question);

  }


  public getQuestionOfQuizForTest(qId :number):Observable<Question[]>{
    return this._http.get<Question[]>(`${baseUrl}/question/quiz/${qId}`);

  }

  //eval-quiz
  public evalQuiz(questions:Question[]):Observable<Object>{
    return this._http.post(`${baseUrl}/question/eval-quiz`,questions)
  }
}

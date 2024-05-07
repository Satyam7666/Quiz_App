import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quiz } from '../Classes/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private _http: HttpClient) { }
  public quizzes():Observable<Quiz[]>{
    return this._http.get<Quiz[]>(`${baseUrl}/quiz/`)
  }

  //add quiz
  public addQuiz(quiz : Quiz):Observable<Object>{
   return this._http.post(`${baseUrl}/quiz/`,quiz);
      
  }

  //delte quiz
  public deleteQuiz(qid: Number):Observable<object>{
    return this._http.delete(`${baseUrl}/quiz/${qid}`);
  }

  //get the single quiz

  public getQuiz(qId :number):Observable<Quiz>{
    return this._http.get<Quiz>(`${baseUrl}/quiz/${qId}`);
  }

  public updateQuiz(quizId:number,quiz:Quiz):Observable<object>{
    return this._http.put(`${baseUrl}/quiz/${quizId}`,quiz);
  }

  //get Quizzes of category
  public getQuizzesOfCategory(cId:any){
    return this._http.get(`${baseUrl}/quiz/category/${cId}`)
  }


  // get Active quizzess
  public getActiveQuizzes():Observable<Quiz[]>{
    return this._http.get<Quiz[]>(`${baseUrl}/quiz/active`);
  }

  //get active quizzes of category
  public getActiveQuizzesofCategory(cId:any):Observable<Quiz[]>{
    return this._http.get<Quiz[]>(`${baseUrl}/quiz/category/active/${cId}`);
  }
}

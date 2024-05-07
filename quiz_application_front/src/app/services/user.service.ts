import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Observable } from 'rxjs';
import { User } from '../Classes/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public addUser(user : User):Observable<object>{
    return this.http.post(`${baseUrl}/user/`,user)

  }

  public updateUser( id:number, user : User):Observable<object>{
    console.log(user);
    return this.http.put(`${baseUrl}/user/update/${id}`,user)

  }

  public getUserByUsername(userName : String):Observable<User>{
    return this.http.get<User>(`${baseUrl}/user/${userName}`)

  }


}

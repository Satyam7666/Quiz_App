import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Category } from '../Classes/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private _http: HttpClient) { }

  public getcategories():Observable<Category[]>{
    return this._http.get<Category[]>(`${baseUrl}/category/`);
  }

  //add category
  public addCategory(category:Category):Observable<object>{
    return this._http.post(`${baseUrl}/category/`,category);
  }
}

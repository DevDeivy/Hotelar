import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { user } from '../interface/user';
import { Observable } from 'rxjs';
import { routApi } from './routApi';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private router = inject(Router);
  private http = inject(HttpClient);
  public urlCreate?: any;
  
  constructor(){
    this.urlCreate = routApi.createUser;
  }


  createUser(user: user): Observable<any>{
    return this.http.post(`${this.urlCreate}/api/create`, user)
  }
}

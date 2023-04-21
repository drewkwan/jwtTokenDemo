import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginData, User, UserData } from '../models/UserData';
import { BehaviorSubject, Subject, lastValueFrom } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) { }

  loadUser!: User;
  userChange = new BehaviorSubject<User|null>(null);
  

  register(data: UserData) {
    const body = {
      username: data.username,
      password: data.password,
      firstName: data.firstName,
      lastName: data.lastName
    }
    this.http.post("http://localhost:8080/api/registerUser", body).subscribe(response=>{
      console.log(response);
    })
  }

  login(data: LoginData): Promise<any> {
    const body = {
      username: data.username,
      password: data.password
    }

    return lastValueFrom(this.http.post("http://localhost:8080/authenticate", body))
  }

}

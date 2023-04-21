import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { User, UserToken } from './models/UserData';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'jwtDemoNg';
  currUser!: User | null;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {

    this.autoLogin();
    
  }

  autoLogin() {

    this.currUser = JSON.parse(localStorage.getItem("userData")!);
    if (!this.currUser) {
      this.router.navigate(['']);
    }

    const expirationDate = this.currUser!.exp * 1000;
    if (new Date().getTime()<expirationDate && this.currUser) {
      this.router.navigate(['/home']);
    } else {
      this.logout()
    }
  }

  logout() {
    localStorage.removeItem("userData");
    this.currUser = null;
    this.router.navigate([''])
  }
}

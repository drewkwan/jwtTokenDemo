import { Component, OnInit, ViewChild } from '@angular/core';
import { AppComponent } from '../app.component';
import { User } from '../models/UserData';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  @ViewChild(AppComponent)
  appComponent!: AppComponent;

  ngOnInit() {}
  print() {
    console.log(localStorage.getItem('userData'));
  }
}

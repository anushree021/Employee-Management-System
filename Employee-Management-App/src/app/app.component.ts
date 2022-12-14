import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './Models/User';
import { SecurityService } from './Services/security.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(
  ) { }

  title = 'Employee Management System';
  footer = 'All Rights Reserved 2022 @AnushreeChakraborty';

  ngOnInit(): void {
  }
}

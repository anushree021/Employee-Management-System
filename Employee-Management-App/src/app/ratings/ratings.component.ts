import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../Models/employee';
import { Ratings } from '../Models/Ratings';
import { EmployeeService } from '../Services/employee.service';
import { RatingsService } from '../Services/ratings.service';
import { SecurityService } from '../Services/security.service';

@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.css']
})
export class RatingsComponent implements OnInit {

  ratings : Ratings[] = [];
  employees : Employee[] = [];

  constructor(
    private ratingsService : RatingsService,
    private securityService : SecurityService,
    private employeeService : EmployeeService,
    private router : Router,
  ) { }

  ngOnInit(): void {
    //login comes
    this.securityService.healthCheck().subscribe(
      (data)=>{
      },
      (err)=>{
        this.router.navigate(['error']);
      },
      ()=>{
        this.employeeService.healthCheck().subscribe(
          (data)=>{
          },
          (err)=>{
            this.router.navigate(['error']);
          },
          ()=>{
            this.ratingsService.healthCheck().subscribe(
              (data)=>{
              },
              (err)=>{
                this.router.navigate(['error']);
              },
              ()=>{
                this.securityService.checkAuthFromLocal('ratings', 'login');
                this.getRatings();
                this.getEmployeesByRating();
              }
            );
          }
        );
      }
    );
  }

  private getRatings(){
    this.ratingsService.getRatingsList().subscribe(data => {
      this.ratings = data;
    });
  }

  private getEmployeesByRating(){
    this.employeeService.getEmployeesSortedByRatings().subscribe(data => {
      this.employees = data;
    });
  }

}

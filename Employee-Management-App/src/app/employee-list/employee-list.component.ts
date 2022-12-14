import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from '../Models/employee';
import { EmployeeService } from '../Services/employee.service';
import { SecurityService } from '../Services/security.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];

  constructor(
     private employeeService: EmployeeService,
     private router: Router,
     private securityService: SecurityService) { }

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
            this.securityService.checkAuthFromLocal('employees', 'login');
            this.getEmployees();
          }
        );
      }
    );
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
  }

  employeeDetails(id: number){
    this.router.navigate(['employee-details', id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees();
    });
  }

}

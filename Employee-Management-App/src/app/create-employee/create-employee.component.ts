import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../Models/employee';
import { EmployeeService } from '../Services/employee.service';
import { SecurityService } from '../Services/security.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();

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
            this.securityService.checkAuthFromLocal('create-employee', 'login');
          }
        );
      }
    );
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

}

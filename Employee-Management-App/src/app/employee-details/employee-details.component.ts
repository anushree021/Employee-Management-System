import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Employee } from '../Models/employee';
import { EmployeeService } from '../Services/employee.service';
import { SecurityService } from '../Services/security.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number = 0;
  employee: Employee = new Employee();

  constructor(
    private route: ActivatedRoute, 
    private employeeService: EmployeeService,
    private securityService: SecurityService,
    private router: Router) { }

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
            this.id = this.route.snapshot.params['id'];
          },
          (err)=>{
            this.router.navigate(['error']);
          },
          ()=>{
            this.securityService.checkAuthFromLocal('employee-details/id', 'login');

            this.employeeService.getEmployeeById(this.id).subscribe(data => {
              this.employee=data;
            });
          }
        );
      }
    );
  }

}

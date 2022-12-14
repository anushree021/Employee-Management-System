import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../Models/employee';
import { EmployeeService } from '../Services/employee.service';
import { SecurityService } from '../Services/security.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number = 0;
  employee: Employee = new Employee();

  constructor(
    private employeeService: EmployeeService,
    private securityService: SecurityService,
    private route: ActivatedRoute, 
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
            this.securityService.checkAuthFromLocal('update-employee/id', 'login');

            this.employeeService.getEmployeeById(this.id).subscribe(data => {
              this.employee = data;
            }, error => console.log(error));
          }
        );
      }
    );
  }

  onSubmit(){
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
      this.goToEmployeeList();
    }, error => console.log(error));
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from '../Models/employee';
import { Microservices } from '../Models/Microservices';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = Microservices["employee-system"];

  constructor(private httpClient: HttpClient) { }

  healthCheck() {
    return this.httpClient.get(this.baseURL+'/health-check',{responseType:'text'});
  }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  getEmployeesSortedByRatings(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL+'/ratings');
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}

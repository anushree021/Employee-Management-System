import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../Models/employee';
import { Microservices } from '../Models/Microservices';
import { Ratings } from '../Models/Ratings';

@Injectable({
  providedIn: 'root'
})
export class RatingsService {

  private baseURL = Microservices["employee-ratings"];

  constructor(private httpClient: HttpClient) { }

  healthCheck() {
    return this.httpClient.get(this.baseURL+'/health-check',{responseType:'text'});
  }

  getRatingsList(): Observable<Ratings[]>{
    return this.httpClient.get<Ratings[]>(this.baseURL+'/ratings-list');
  }
}

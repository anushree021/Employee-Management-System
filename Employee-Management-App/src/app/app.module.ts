import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { ServerErrorComponent } from './server-error/server-error.component';
import { DatePipe } from '@angular/common';
import { AuthenticationRequest } from './Models/AuthenticationRequest';
import { SecurityToken } from './Models/SecurityToken';
import { LoginStatus } from './Models/LoginStatus';
import { ProjectDetails } from './Models/ProjectDetails';
import { SpecialFLag } from './Models/SpecialFlag';
import { User } from './Models/User';
import { AuthorizationMsclientService } from './HttpClients/authorization-msclient.service';
import { TokenInterceptorService } from './Services/token-interceptor.service';
import { EmployeeService } from './Services/employee.service';
import { NavHeaderComponent } from './nav-header/nav-header.component';
import { RatingsComponent } from './ratings/ratings.component';
import { RatingsService } from './Services/ratings.service';
import { Ratings } from './Models/Ratings';
import { Employee } from './Models/employee';

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,
    LoginComponent,
    ServerErrorComponent,
    NavHeaderComponent,
    RatingsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    EmployeeService,
    Employee,
    RatingsService,
    Ratings,
    DatePipe,
    AuthenticationRequest,
    SecurityToken,
    LoginStatus,
    ProjectDetails,
    SpecialFLag,
    User,
    AuthorizationMsclientService,
    {   // for token interceptor
      provide : HTTP_INTERCEPTORS,
      useClass : TokenInterceptorService,
      multi : true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

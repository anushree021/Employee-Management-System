import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { Microservices } from '../Models/Microservices';
import { ProjectDetailsInterface } from '../Models/ProjectDetailsInterface';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationMsclientService {

  constructor(private authClient : HttpClient) { }

  authenticate(authRequest : AuthenticationRequest){
    // make rest call [POST] to /authenticate with authRequest as Request-body
    return this.authClient.post(Microservices["auth"]+"/authenticate", authRequest, 
                          { responseType : 'text',
                            //observe : 'response'
                        });
  }

  validate(securityToken : string){
    return this.authClient.post<ProjectDetailsInterface>(Microservices["auth"]+"/validate", 
      {
        headers: new HttpHeaders().set("Authorization", "Bearer "+securityToken)
      });
  }

  healthCheck(){
    return this.authClient.get(Microservices["auth"]+"/health-check", {
      responseType : 'text'
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../Models/User';
import { SecurityService } from '../Services/security.service';

@Component({
  selector: 'app-nav-header',
  templateUrl: './nav-header.component.html',
  styleUrls: ['./nav-header.component.css']
})
export class NavHeaderComponent implements OnInit {

  constructor(
    private securityService : SecurityService,
    private router : Router,
    public user : User
  ) { }

  logout(){
    this.securityService.resetAll();
    this.router.navigate(['login']);
  }

  ngOnInit(): void {
    if(this.securityService.getLoginStatus()){
      let nameArray : Array<string> = this.securityService.getProjectDetails().Name.split(" ");
      this.user.username = nameArray[0] + " " + nameArray[1][0] + ".";
      this.user.logStatus = this.securityService.getLoginStatus();
    }
  }

}

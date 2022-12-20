import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public username: any;
  public password: any;
  public response: any;
  constructor(private http: HttpClient, private router : Router) {
  }
  

  onSubmit(data : any){
  this.username = data.form.value.username;
  this.password = data.form.value.password;
  this.http.post(`http://localhost:8080/login?username=${this.username}&password=${this.password}`,{username:this.username,password:this.password}).subscribe((data)=>{
   this.response = data;

  if(this.response.message == 'OK')
    this.router.navigate(['/main'])
  
  if(this.response.message == 'NOT FOUND')
  this.router.navigate(['/login'])

  })
  }
}

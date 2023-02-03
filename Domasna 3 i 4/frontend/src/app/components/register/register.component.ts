import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router"


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  public username: any;
  public password: any;
  public confirmPassword: any;
  public response: any;

  constructor(private http: HttpClient, private router : Router) {
  }


  onRegister(data:any){
    this.username = data.form.value.username;
    this.password = data.form.value.password;
    this.confirmPassword = data.form.value.confirmPassword;

    this.http.post(`http://localhost:9000/users/register?username=${this.username}&password=${this.password}&confirmPassword=${this.confirmPassword}`,{username:this.username,password:this.password,confirmPassword: this.confirmPassword}).subscribe((data)=>{
    this.response = data;

    if(this.response.message == 'OK'){
      this.router.navigate(['/login'])
    }
    else{
      alert(this.response.message)
      this.router.navigate(['/register'])
    }
  
  
    
  })

  }
}

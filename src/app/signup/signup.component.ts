import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserDTO } from 'src/dto/userdto';
import {Usertype} from 'src/dto/usertype';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  loginDTO: LoginDTO;

  userDto: UserDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  signup(f: NgForm): void{ 

    //this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.userDto = new UserDTO();

    this.userDto.username = f.value.username;
    this.userDto.password = f.value.password;
    this.userDto.usertype = Usertype.USER;

    this.service.insert(this.userDto).subscribe(user => this.userDto = user);

    localStorage.setItem('currentUser', JSON.stringify(this.userDto));

    this.router.navigate(['/user-dashboard']);

  }

}

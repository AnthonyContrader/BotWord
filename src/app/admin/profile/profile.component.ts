import { AdminMenuComponent } from './../../layout/admin-layout/admin-menu/admin-menu.component';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: UserDTO = new UserDTO();
  

  constructor(private service: UserService) { }


  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
   }

  
  update(user: UserDTO) {
    this.service.update(user).subscribe();
    alert("riesegui l'accesso");
  
    
  }

  }


  





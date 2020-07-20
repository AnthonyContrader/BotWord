import { Component, OnInit } from "@angular/core";
import { UserService } from "src/service/user.service";
import { UserDTO } from "src/dto/userdto";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"],
})
export class ProfileComponent implements OnInit {
  user: UserDTO = new UserDTO();
  copyUser: UserDTO = new UserDTO();

  constructor(private service: UserService) {}

  ngOnInit() {
    if (localStorage.getItem("currentUser") != null) {
      this.user = JSON.parse(localStorage.getItem("currentUser"));
      this.copyUser = JSON.parse(localStorage.getItem("currentUser"));
    }
  }

  update(user: UserDTO) {
    this.service.update(user).subscribe();
    localStorage.setItem("currentUser", JSON.stringify(user));
    alert("modifiche aggiornate");
  }

  reset(user: UserDTO) {
    user.username = this.copyUser.username;
    user.password = this.copyUser.password;
  }
}

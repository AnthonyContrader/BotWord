import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {


  isAccountCollapsed = false;
  isProductCollapsed = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  productCollapse(){
    if(this.isProductCollapsed===false){
      this.isProductCollapsed = true;
    }
    else{
      this.isProductCollapsed = false;
    }
  }

}

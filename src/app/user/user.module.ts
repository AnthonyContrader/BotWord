import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserRoutingModule } from './user-routing.module';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ShoppingListsComponent } from '../shoppinglists/shoppinglists.component';
import { ShoppingListDetailsComponent } from '../shoppinglist-details/shoppinglist-details.component';


@NgModule({
    declarations: [UserDashboardComponent, ProductsComponent, ProductDetailsComponent, ProductCategoryComponent],
    imports: [
      CommonModule,
      UserRoutingModule,
      FormsModule
    ]
  })
  export class UserModule { }

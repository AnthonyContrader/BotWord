import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ShoppingListsComponent } from '../shoppinglists/shoppinglists.component';
import { ShoppingListDetailsComponent } from '../shoppinglist-details/shoppinglist-details.component';


const routes: Routes = [
    {path: 'user-dashboard', component: UserLayoutComponent, children:[
        {path: '', component: UserDashboardComponent},
        {path: 'products', component: ProductsComponent},
        {path: 'product-details/:id', component: ProductDetailsComponent},
        {path: 'product-category/:category', component: ProductCategoryComponent},
        {path: 'shoppinglists', component: ShoppingListsComponent},
        {path: 'shoppinglist-details/:id', component: ShoppingListDetailsComponent}
    ]}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })

export class UserRoutingModule { }

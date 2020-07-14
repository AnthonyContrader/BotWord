import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';



const routes: Routes = [
    {path: 'user-dashboard', component: UserLayoutComponent, children:[
        {path: '', component: UserDashboardComponent},
        {path: 'products', component: ProductsComponent},
        {path: 'product-details/:id', component: ProductDetailsComponent}
    ]}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  
export class UserRoutingModule { }
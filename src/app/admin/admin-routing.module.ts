import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ShoppingListsComponent } from '../shoppinglists/shoppinglists.component';
import { ShoppingListDetailsComponent } from '../shoppinglist-details/shoppinglist-details.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri
 * (qui sotto sono indentati).
 *
 * @author Vittorio Valent
 *
 * @see AdminLayoutComponent
 *
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'products', component: ProductsComponent},
    {path: 'product-details/:id', component: ProductDetailsComponent},
    {path: 'product-category/:category', component: ProductCategoryComponent},
    { path: 'shoppinglists', component: ShoppingListsComponent},
    {path: 'shoppinglist-details/:id', component: ShoppingListDetailsComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }

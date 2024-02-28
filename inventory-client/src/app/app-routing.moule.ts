import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './ui/products/products.component';
import { CustomersComponent } from './ui/customers/customers.component';
import { AuthGuard } from './guards/auth.guard';
import { OrdersComponent } from './ui/orders/orders.component';
import { OrderDetailComponent } from './ui/order-detail/order-detail.component';

const routes: Routes = [
    { path: 'products', component: ProductsComponent, canActivate: [AuthGuard], data: { roles: ['ADMIN'] }},
    { path: 'customers', component: CustomersComponent, canActivate: [AuthGuard], data: { roles: ['USER'] }},
    { path: 'orders', component: OrdersComponent, canActivate: [AuthGuard], data: { roles: ['USER'] }},
    { path: 'orders/:id', component: OrderDetailComponent, canActivate: [AuthGuard], data: { roles: ['USER'] }}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
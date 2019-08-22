import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductComponent} from './components/product/product.component';
import {KardexComponent} from './components/kardex/kardex.component';


const routes: Routes = [
  { path: '', redirectTo: 'products', pathMatch: 'full'},
  { path: 'products', component: ProductComponent },
  { path: 'kardex', component: KardexComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

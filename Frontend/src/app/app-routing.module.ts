import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {MenuComponent} from './components/menu/menu.component';
import {MenuvComponent} from './components/menuv/menuv.component';


const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'menu', component: MenuComponent},
  { path: 'menuv', component: MenuvComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

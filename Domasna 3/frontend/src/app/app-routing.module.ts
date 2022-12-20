import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MapComponent} from "./components/map/map.component";
import {MainComponent} from "./components/main/main.component";
import {LoginComponent} from "./components/login/login.component";
import { RegisterComponent } from "./components/register/register.component";
 
const routes: Routes = [
  {
    path: 'map',
    component: MapComponent
  },
  {
    path: 'main',
    component: MainComponent
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

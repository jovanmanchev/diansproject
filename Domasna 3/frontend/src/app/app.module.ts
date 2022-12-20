import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from './components/main/main.component';
import {MapComponent} from './components/map/map.component';
import {HttpHeaders, HttpClient, HttpClientModule} from "@angular/common/http";
import { AgmCoreModule } from '@agm/core';
import { AgmDirectionModule  } from 'agm-direction';
import {LoginComponent} from "./components/login/login.component";
import { RegisterComponent } from './components/register/register.component' 
import { FormsModule } from '@angular/forms';
//AIzaSyBs_734czgjKtdGAdankJONkoA613Wdygw
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    MapComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AgmDirectionModule  ,
    AgmCoreModule.forRoot({
      apiKey: ''
    }),
   

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from './components/main/main.component';
import {MapComponent} from './components/map/map.component';
import {HttpHeaders, HttpClient, HttpClientModule} from "@angular/common/http";


//AIzaSyBs_734czgjKtdGAdankJONkoA613Wdygw
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    MapComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

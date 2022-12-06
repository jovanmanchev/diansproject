import { Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";


//AIzaSyBs_734czgjKtdGAdankJONkoA613Wdygw
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  public dataObj: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.getMethod();
  }

  public getMethod() {
    this.http.get('http://localhost:8080/hospitals').subscribe((data) => {
      this.dataObj = data;
    })
  }

}

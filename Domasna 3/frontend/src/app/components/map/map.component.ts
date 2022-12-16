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
  lat : number = 41.608635;
  lon: number = 21.745275;
  public agmMarkers: agmmarker[] = [];
  public hospitalNames: any[] = [];
  public currentName: any;
  public showName: boolean = false;
  public ipAdress: any;
  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.getMethod();
    this.http.get("https://api.ipify.org?format=json").subscribe((data) => {
      this.ipAdress = data;
      console.log(this.ipAdress.ip)
      this.http.get(`http://localhost:8080/user/location?ipAddress=${this.ipAdress.ip}`).subscribe((data) => {
        let key1 = 'latitude'
        let key2 = 'longitude'
       
        this.lat = Number(data[key1 as keyof typeof data])
        this.lon = Number(data[key2 as keyof typeof data])
       

      })
    })
    
   
  }

  public getMethod() {
    this.http.get('http://localhost:8080/hospitals').subscribe((data) => {
      
      this.dataObj = data;
      let counter = 0
      for (let obj in data){
       
        let info = data[obj as keyof typeof data]
        let str = 'lat'
        let str2 = 'lon'
        let str3 = 'name';
        let hospitalName = info[str3 as keyof typeof info]
        let lat = info[str as keyof typeof info]
        let lon = info[str2 as keyof typeof info]
        this.hospitalNames.push(hospitalName);
        this.agmMarkers.push({
          lat: Number(lat),
          lon: Number(lon),
          index: counter++
        })
      }
      
    })
  }
  public showInfo(index: number){
    let hospitalName = this.hospitalNames[index]
    this.currentName = hospitalName
    this.showName = true;
   
  }
}

interface agmmarker {
  lat: number;
  lon: number;
  index: number;
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "../model/vehicle";

@Injectable({
  providedIn: 'root'
})
export class ListvehiclesService {


  constructor(private http:HttpClient) { }
  Url ='/api/vehicle/listvehicles';

  getVehicles(){

     return this.http.get<Vehicle[]>(this.Url);

  }

}

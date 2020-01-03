import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "../model/vehicle";


@Injectable({
  providedIn: 'root'
})
export class AddVehiclesService {

  constructor(private http:HttpClient) {


  }
  Url ='/api/vehicle';

  addVehicle(vehicle: Vehicle){

    return this.http.post<Vehicle>(this.Url,vehicle);

  }



}

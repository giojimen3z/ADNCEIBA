import { Component, OnInit } from '@angular/core';
import  {ListvehiclesService} from  './../../services/listvehicles.service'
import {Router} from "@angular/router";
import {Vehicle} from "../../model/vehicle";

@Component({
  selector: 'app-vehiclelist',
  templateUrl: './vehiclelist.component.html',
  styleUrls: ['./vehiclelist.component.scss']
})
export class VehiclelistComponent implements OnInit {

  vehicles: Vehicle[];
  constructor (private service: ListvehiclesService , private router:Router ) { }

  ngOnInit() {

    this.service.getVehicles().subscribe(data => {this.vehicles=data});
  }

}

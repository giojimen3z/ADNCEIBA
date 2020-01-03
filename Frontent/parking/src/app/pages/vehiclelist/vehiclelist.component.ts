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

  openFactura(plate){

    this.service.getBill(plate).subscribe( data => {
      //LLENAR UN ARRAY CON LOS DATOS OBTENIDOS Y MOSTRARLOS EN EL CODIGO DE LA FACTURA
      console.log(data);
    });

    document.getElementById('factura').style.display = 'block';
    console.log(plate)
  }

  closeFactura(){
    document.getElementById('factura').style.display = 'none';
  }

}

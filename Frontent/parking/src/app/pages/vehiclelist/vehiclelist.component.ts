import { Component, OnInit } from '@angular/core';
import  {ListvehiclesService} from  './../../services/listvehicles.service'
import {Router} from "@angular/router";
import {Vehicle} from "../../model/vehicle";
import { Bill } from 'src/app/model/Bill';
import { Parking } from 'src/app/model/Parking';


@Component({
  selector: 'app-vehiclelist',
  templateUrl: './vehiclelist.component.html',
  styleUrls: ['./vehiclelist.component.scss']
})
export class VehiclelistComponent implements OnInit {


  vehicles: Vehicle[];
  bill: Bill;
  constructor (private service: ListvehiclesService , private router:Router ) { }

  ngOnInit() {

    this.service.getVehicles().subscribe(data => {this.vehicles=data});
  }

  openFactura(plate){

    this.service.getBill(plate).subscribe( data => {
  
      this.createdBill(data)
      
    });

    console.log(plate)
  }
  createdBill(data){
     this.bill =  new Bill();

     this.bill.Parking = new Parking;
    this.bill.Vehicle = new Vehicle;

    this.bill.Parking.parkingId  = data.parking.parkingId
    this.bill.Parking.vehicleId  = data.parking.vehicleId
    this.bill.Parking.parkingEnterDate  = data.parking.parkingEnterDate
    this.bill.Parking.parkingExitDate  = data.parking.parkingExitDate
    this.bill.Parking.parkingTotal  = data.parking.parkingTotal

    this.bill.Vehicle.typeId  = data.vehicle.typeId
    this.bill.Vehicle.ccVehicle  = data.vehicle.ccVehicle
    this.bill.Vehicle.plateVehicle  = data.vehicle.plateVehicle
   
    document.getElementById('factura').style.display = 'block';
   
  }
  closeFactura(){
    document.getElementById('factura').style.display = 'none';
  }

  pagar(){
    var plate =  this.bill.Vehicle.plateVehicle;

    console.log(plate);
    
    this.service.deleteVehicle(plate).subscribe(data=>{
        alert("EL vehiculo salio correctamente" +data)
      })

      this.router.navigate(["menu"]);


  }
}

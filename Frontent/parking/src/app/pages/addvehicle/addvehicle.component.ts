import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {formatDate} from "@angular/common";
import {Router} from "@angular/router";
import {Vehicle} from "../../model/vehicle";
import {AddVehiclesService} from "./../../services/add-vehicles.service"

@Component({
  selector: 'app-addvehicle',
  templateUrl: './addvehicle.component.html',
  styleUrls: ['./addvehicle.component.scss']
})
export class AddvehicleComponent implements OnInit {

  typeId = new FormControl('');
  plate = new FormControl('');
  cc = new FormControl('');
  vehicle: Vehicle;

  today= new Date();
  jstoday = '';
  constructor( private router:Router, private service: AddVehiclesService) {

    this.jstoday = formatDate(this.today, 'dd-MM-yyyy hh:mm:ss a', 'en-US', '-05');


  }

  public vehicleType(){


    if (this.typeId.value == 1){

      return true;
    }else {

      return  false;
    }


  }
  ngOnInit() {
  }

  saveVehicle(){

    const data = {
      // vehicleId: 7,
      typeId: this.typeId.value,
      ccVehicle: this.cc.value,
      plateVehicle: this.plate.value
    }

    this.service.addVehicle(data).subscribe(data=>{
      alert("El vehiculo se agrego crorrectamente");
      this.router.navigate([["vehicles"]]);
    })

  }
}

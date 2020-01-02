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

  selectOption = new FormControl('');

  vehicle: Vehicle;

  today= new Date();
  jstoday = '';
  constructor( private router:Router, private service: AddVehiclesService) {

    this.jstoday = formatDate(this.today, 'dd-MM-yyyy hh:mm:ss a', 'en-US', '-05');


  }

  public vehicleType(){


    if (this.selectOption.value == 1){

      return true;
    }else {

      return  false;
    }


  }
  ngOnInit() {
  }

  saveVehicle(){

    this.vehicle.typeId = this.selectOption.value;


    this.service.addVehicle(this.vehicle).subscribe(data=>{
      alert("El vehiculo se agrego crorrectamente");
      this.router.navigate([["vehicles"]]);
    })
  }
}

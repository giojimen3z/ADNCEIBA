import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-addvehicle',
  templateUrl: './addvehicle.component.html',
  styleUrls: ['./addvehicle.component.scss']
})
export class AddvehicleComponent implements OnInit {

  selectOption = new FormControl('');

  today= new Date();
  jstoday = '';
  constructor() {

    this.jstoday = formatDate(this.today, 'dd-MM-yyyy hh:mm:ss a', 'en-US', '-05');


  }

  public vehicleType(){


    if (this.selectOption.value == 'Moto'){

      return true;
    }else {

      return  false;
    }


  }
  ngOnInit() {
  }

}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehiclelistRoutingModule } from './vehiclelist-routing.module';
import { VehiclelistComponent } from './vehiclelist.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [VehiclelistComponent],
  imports: [
    CommonModule,
    VehiclelistRoutingModule,
    FormsModule
  ]
})
export class VehiclelistModule { }

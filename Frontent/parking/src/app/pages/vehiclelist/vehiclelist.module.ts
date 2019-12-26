import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehiclelistRoutingModule } from './vehiclelist-routing.module';
import { VehiclelistComponent } from './vehiclelist.component';


@NgModule({
  declarations: [VehiclelistComponent],
  imports: [
    CommonModule,
    VehiclelistRoutingModule
  ]
})
export class VehiclelistModule { }

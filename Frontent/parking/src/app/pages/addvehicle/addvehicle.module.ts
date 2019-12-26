import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddvehicleRoutingModule } from './addvehicle-routing.module';
import { AddvehicleComponent } from './addvehicle.component';


@NgModule({
  declarations: [AddvehicleComponent],
  imports: [
    CommonModule,
    AddvehicleRoutingModule
  ]
})
export class AddvehicleModule { }

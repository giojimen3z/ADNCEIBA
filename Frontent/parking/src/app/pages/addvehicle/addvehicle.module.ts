import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddvehicleRoutingModule } from './addvehicle-routing.module';
import { AddvehicleComponent } from './addvehicle.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [AddvehicleComponent],
  imports: [
    CommonModule,
    AddvehicleRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class AddvehicleModule { }

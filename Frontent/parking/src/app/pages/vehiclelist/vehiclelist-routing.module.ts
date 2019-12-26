import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VehiclelistComponent} from "./vehiclelist.component";


const routes: Routes = [{path: '', component: VehiclelistComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehiclelistRoutingModule { }

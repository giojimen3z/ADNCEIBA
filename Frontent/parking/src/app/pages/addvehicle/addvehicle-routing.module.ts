import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddvehicleComponent} from './addvehicle.component';


const routes: Routes = [{path: '', component: AddvehicleComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AddvehicleRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MyproductsRoutingModule } from './myproducts-routing.module';
import { MyproductsComponent } from './myproducts.component';
import {MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [MyproductsComponent],
  imports: [
    CommonModule,
    MyproductsRoutingModule,
    MatCardModule
  ]
})
export class MyproductsModule { }

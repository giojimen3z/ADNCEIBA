import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu.component';
import { MatSidenavModule, MatListModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material';


@NgModule({
  declarations: [MenuComponent],
  imports: [
    CommonModule,
    MatSidenavModule,
    RouterModule,
    MatListModule,
    MatIconModule
  ]
})
export class MenuModule { }

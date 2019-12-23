import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';  

import {
  MatButtonModule,
  MatInputModule,
  MatToolbarModule,
  MatIconModule,
  MatCardModule
} from '@angular/material';

import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
     MatCardModule,
      MatInputModule,
      MatButtonModule,
      FormsModule,
      MatToolbarModule,
      MatIconModule,
      MatSnackBarModule,
      NgbModule  
  ]
})
export class LoginModule { }

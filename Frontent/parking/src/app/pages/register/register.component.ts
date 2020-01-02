import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  Nombre: string;
  Genero: string;
  Correo: string;
  Usuario: string;
  Password: string;

  constructor(private router: Router,  private msj: MatSnackBar) { }


  ngOnInit() {
  }

}

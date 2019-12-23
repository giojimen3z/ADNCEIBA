import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './../../services/user.service';
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

  constructor(private router: Router, private user: UserService, private msj: MatSnackBar) { }

  public register(Nombre: string, Genero: string, Correo: string, Usuario: string, Pass: string) {

      const datos = {
        name: Nombre,
        gender: Genero,
        email: Correo,
        user: Usuario,
        password: Pass
      };

      this.user.register(datos).subscribe((rest) => {

        if (rest['status'] === 'success' ) {
          this.msj.open(rest['message'], 'Cerrar', { duration: 2000, });
          this.router.navigate([''], { replaceUrl: true });
        }

      }, (err) => {
          if (err.error.errors) {
            const errores = err.error.errors;
            if (errores.name) {
              document.getElementById('name').innerHTML = errores.name[0];
            } else {
              document.getElementById('name').innerHTML = '';
            }

            if (errores.gender) {
              document.getElementById('gender').innerHTML = errores.gender[0];
            } else {
              document.getElementById('gender').innerHTML = '';
            }

            if (errores.email) {
              document.getElementById('email').innerHTML = errores.email[0];
            } else {
              document.getElementById('email').innerHTML = '';
            }

            if (errores.user) {
              document.getElementById('user').innerHTML = errores.user[0];
            } else {
              document.getElementById('user').innerHTML = '';
            }

            if (errores.password) {
              document.getElementById('password').innerHTML = errores.password[0];
            } else {
              document.getElementById('password').innerHTML = '';
            }
          }

          this.msj.open(err.error.message, 'Cerrar', { duration: 2000, });
        }
      );

  }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './../../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  Usuario: string;
  password: string;
  constructor(private router: Router, private user: UserService, private msj: MatSnackBar,config: NgbCarouselConfig) {

    config.interval = 2000;  
    config.wrap = true;  
    config.keyboard = false;  
    config.pauseOnHover = false;  


  }

  public login(Usuario: string, Pass: string) {

    const datos = {
      user: Usuario,
      password: Pass
    };

    this.user.login(datos).subscribe((rest) => {
      console.log(rest);
      if (rest['status'] === 'success' ) {
        this.msj.open(rest['message'], 'Cerrar', { duration: 2000, });
        this.user.setToken(rest['token']);
        this.router.navigate(['menu'], { replaceUrl: true });
      } else {
        if (rest['errors']) {
              const errores = rest['errors'];
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

              this.msj.open(rest['message'], 'Cerrar', { duration: 2000, });
          } else {
            this.msj.open(rest['message'], 'Cerrar', { duration: 2000, });
          }
      }

    }, (err) => {
      console.log(err);

    }
  );
  }


  ngOnInit() {}
}

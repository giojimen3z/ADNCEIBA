import { Component, OnInit, ɵConsole } from '@angular/core';
import { ListasService } from './../../services/listas.service';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.scss']
})
export class MarketComponent implements OnInit {

  categorias: string[] = [];
  marcas: string[] = [];
  estados: string[] = [];
  tallas: string[] = [];

  DatoCategoria;
  category: number;
  type: number;
  talla: number;
  brand: number;
  state: number;

  constructor(private lista: ListasService) {

    this.lista.getCategory().subscribe((data) => {
      const option = data['users'];
      option.map((cat) => {
        this.categorias.push(cat);
      });
    });

    this.lista.getBrand().subscribe((data) => {
      const option = data['users'];
      option.map((cat) => {
        this.marcas.push(cat);
      });
    });

    this.lista.getState().subscribe((data) => {
      const option = data['users'];
      option.map((cat) => {
        this.estados.push(cat);
      });
    });

    this.lista.getTalla().subscribe((data) => {
      const option = data['users'];
      option.map((cat) => {
        this.tallas.push(cat);
      });
    });

   }

  ngOnInit() {
  }

  subCategoria(dato) {

    if (dato === 1) {
      this.DatoCategoria = true;
    } else {
      this.DatoCategoria = false;
    }

  }

}

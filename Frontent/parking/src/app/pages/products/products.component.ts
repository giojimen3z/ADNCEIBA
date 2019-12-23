import { Component, OnInit } from '@angular/core';
import { ProductsService } from './../../services/products.service';
import { UserService } from './../../services/user.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  productos: string[] = [];
  token: string;

  constructor(private products: ProductsService, private user:UserService) {
    this.token = this.user.getToken();    
    this.products.getproducts(this.token).subscribe((data) =>{
      data['products'].map((value) =>{
        this.productos.push(value)        
      })         
    })

    console.log(this.productos)
  }

  ngOnInit() {
  }

}

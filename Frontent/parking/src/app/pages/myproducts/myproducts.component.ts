import { Component, OnInit } from '@angular/core';
import { ProductsService } from './../../services/products.service';
import { UserService } from './../../services/user.service';

@Component({
  selector: 'app-myproducts',
  templateUrl: './myproducts.component.html',
  styleUrls: ['./myproducts.component.scss']
})
export class MyproductsComponent implements OnInit {

  productos: string[] = [];
  token: string;

  constructor(private products: ProductsService, private user:UserService) {
    this.token = this.user.getToken();    
    this.products.getproduct(this.token).subscribe((data) =>{
      console.log(data)
      // data['products'].map((value) =>{
      //   this.productos.push(value)        
        
      // })         
    })

    // console.log(this.productos)
  }

  ngOnInit() {
  }

}

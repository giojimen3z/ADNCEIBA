import { Injectable } from '@angular/core';
import { PathService } from './path.service';
import { UserService } from './user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  path: string;

  constructor(private http: HttpClient, url: PathService) {
    this.path = url.getUrl();    
  }

   getproduct(token){
    
    const headersHttp: HttpHeaders  = new HttpHeaders({
      'content-type': 'appication/json',
      'Authorization': token
    });     

    return this.http.get(this.path + 'product/show/user' , {headers: headersHttp});

   }

  getproducts(token){
    
    const headersHttp: HttpHeaders  = new HttpHeaders({
      'content-type': 'appication/json',
      'Authorization': token    
    });        
    
    return this.http.get(this.path + 'product/show', {headers: headersHttp});

  }

  create(data, token){    
    
      const headersHttp: HttpHeaders  = new HttpHeaders({
        'content-type': 'appication/json',
        'Authorization': token
      });       
       
      const params = data;
  
      return this.http.post(this.path + 'product/new', params , {headers: headersHttp});
  }

  update(data, id, token){    
    
    const headersHttp: HttpHeaders  = new HttpHeaders({
      'content-type': 'appication/json',
      'Authorization': token
    });       
     
    const params = data;

    return this.http.post(this.path + 'product/update/' + id, params , {headers: headersHttp});
  }

}

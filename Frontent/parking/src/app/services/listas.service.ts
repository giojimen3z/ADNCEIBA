import { Injectable } from '@angular/core';
import { PathService } from './path.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListasService {

  path: string;

  constructor(private http: HttpClient, url: PathService) {
    this.path = url.getUrl();
  }

  getCategory() {
    const headersHttp: HttpHeaders  = new HttpHeaders({'content-type': 'appication/json'});
    return this.http.get(this.path + 'category', {headers: headersHttp});
  }

  getBrand() {
    const headersHttp: HttpHeaders  = new HttpHeaders({'content-type': 'appication/json'});
    return this.http.get(this.path + 'brand', {headers: headersHttp});
  }

  getState() {
    const headersHttp: HttpHeaders  = new HttpHeaders({'content-type': 'appication/json'});
    return this.http.get(this.path + 'state', {headers: headersHttp});
  }

  getTalla() {
    const headersHttp: HttpHeaders  = new HttpHeaders({'content-type': 'appication/json'});
    return this.http.get(this.path + 'talla', {headers: headersHttp});
  }

}

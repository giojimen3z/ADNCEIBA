import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PathService } from './path.service';
// import { Observable } from 'rxjs';
import { Data } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  token: string;
  path: string;

  constructor(private http: HttpClient, url: PathService) {
    this.path = url.getUrl();
  }

  register(data: Data) {

    const headersHttp: HttpHeaders  = new HttpHeaders({'content-type': 'appication/json'});

    const json = JSON.stringify(data);

    const params = '?json=' + json;

    return this.http.post(this.path + 'user/register' + params , {headers: headersHttp});

  }

  login(data: Data) {

    const headersHttp: HttpHeaders  = new HttpHeaders({'content-type': 'appication/json'});

    const json = JSON.stringify(data);

    const params = '?json=' + json;

    return this.http.post(this.path + 'user/login' + params , {headers: headersHttp});

  }

  setToken(data) {
    this.token = data;
  }

  getToken() {
    return this.token;
  }

}

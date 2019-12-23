import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PathService {

  urlapi;

  constructor() {

    const hostname = window.location.hostname;

    switch (hostname) {
      case 'localhost':
          this.urlapi = 'http://localhost/tu_closet_api/public/api/';
          break;

      default:
          this.urlapi = 'url producción';
          break;
    }
  }

  getUrl() {

    return this.urlapi;

  }

}


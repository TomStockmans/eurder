
import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';

import { Observable } from 'rxjs';

/** Pass untouched request through to the next request handler. */
@Injectable()
export class CustomInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
        console.log("started to intercept")
        
        if (localStorage.getItem('token') != 'undefined') {
            req = req.clone({ headers: req.headers.set('Authorization', localStorage.getItem('token')) });
        }
        
    return next.handle(req);
    
  }
}

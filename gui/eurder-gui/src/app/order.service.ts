import { Injectable } from '@angular/core';
import { Order } from './order';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl : string = 'http://localhost:8080/orders';
  
  constructor(private http: HttpClient) { }

  addOrder (itemgroup) : Observable<any> {
    
    var order = new Order(null, itemgroup);
    return this.http.post<any>(this.apiUrl, order, {});
   
  }

}

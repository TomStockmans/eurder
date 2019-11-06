import { Injectable } from '@angular/core';
import Axios from 'axios';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor() { }

  apiUrl : string = 'http://localhost:8080/orders';

  async addOrder (itemgroup) : Promise<any> {
    
    var order = new Order(null, itemgroup);

    const response = await Axios.post(this.apiUrl, order).then(response => {
      
      if(response.status == 201){
        return response.data;
      }
    });

    if(response) return response;
  }

}

import { Injectable } from '@angular/core';
import Axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  apiUrl : string = 'http://localhost:8080/users';

  async getAllCustomers() : Promise<any> {
    const response = await Axios.get(this.apiUrl).then(response => {
      if(response.status == 200){
        return response.data;
      }
    });

    if(response) return response;
  }
  
  async getCustomerDetail(id) : Promise<any> {
    const response = await Axios.get(this.apiUrl+"/"+id).then(response => {
      if(response.status == 200){
        return response.data;
      }
    });

    if(response) return response;
  }

  constructor() { }
}

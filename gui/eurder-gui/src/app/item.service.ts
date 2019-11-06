import { Injectable } from '@angular/core';
import { Item } from './item';
import Axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }

  apiUrl : string = 'http://localhost:8080/items';

  async addItem (item : Item) : Promise<any> {
    const response = await Axios.post(this.apiUrl, item).then(response => {
      if(response.status == 201){
        return response.data;
      }
    });

    if(response) return response;
  }

  async getAllItems() : Promise<any> {
    
    const response = await Axios.get(this.apiUrl).then(response => {
      if(response.status == 200){
        return response.data;
      }
    });

    if(response) return response;
  }
}

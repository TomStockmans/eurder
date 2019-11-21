import { Injectable } from '@angular/core';
import { Item } from './item';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient){

  }

  apiUrl : string = 'http://localhost:8080/items';

  addItem (item : Item) : Observable<any> {
    return this.http.post<any>(this.apiUrl, item, {});
  }

  getAllItems() : Observable<any> {
    
    return this.http.get<any>(this.apiUrl);
  }
}

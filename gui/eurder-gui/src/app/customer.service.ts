import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  apiUrl : string = 'http://localhost:8080/users';

  
  constructor(private http: HttpClient) { 

  }
  

  getAllCustomers() : Observable<any> {

    return this.http.get<any>(this.apiUrl);

  }
  
  getCustomerDetail(id) : Observable<any> {
    return this.http.get<any>(this.apiUrl+"/"+id);
  }
}

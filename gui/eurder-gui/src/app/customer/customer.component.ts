import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  
  customers : [];
  customerDetail : any;
  
    constructor(private customerService: CustomerService) { }


  getAllCustomers(){
    this.customerService.getAllCustomers().subscribe(value => this.customers = value)
  }

  showCustomerDetail(id){
    //console.log(JSON.stringify(this.customers))
    this.customerService.getCustomerDetail(id).subscribe(value => this.customerDetail = value)
  }

  ngOnInit() {
    this.getAllCustomers();    
  }

}

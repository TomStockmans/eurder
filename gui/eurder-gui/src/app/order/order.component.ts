import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  itemService = new ItemService();
  orderService = new OrderService();
  items : any;
  shoppingCard = [];
  orderPlaced : any;

  constructor() { }

  getItems(){
   return this.itemService.getAllItems();
  }

  addToCart(id: string){
    this.shoppingCard.push({
      item : 
        this.items.filter(function (item) {
        return item.id == id;
        })[0]
    , 
    amount : 
        (<HTMLInputElement>document.getElementById(id)).value
    });
  }

  isCardNotEmpty(){return this.shoppingCard.length > 0}

  placeOrder(){
    
    this.orderService.addOrder(this.shoppingCard).then(value => this.orderPlaced = value)
  }

  ngOnInit() {
    this.itemService.getAllItems().then(value => this.items = value);
  }

}

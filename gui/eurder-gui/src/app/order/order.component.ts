import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  items : any;
  shoppingCard = [];
  orderPlaced : any;

  constructor(private itemService: ItemService, private orderService: OrderService) { }

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
    
    this.orderService.addOrder(this.shoppingCard).subscribe(value => this.orderPlaced = value)
  }

  ngOnInit() {
    this.itemService.getAllItems().subscribe(value => this.items = value);
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  @Input() item = new Item;
  itemService = new ItemService();
  addedItem: any;

  addItem(): void {
      this.itemService.addItem(this.item).then(value => this.addedItem = value );
  }

  constructor() { }

  ngOnInit() {
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  updateitem = false;
  @Input() item = new Item;
  private items : any;
  
  constructor(private itemService: ItemService) { 

  }
  
  addedItem: any;

  addItem(): void {
    if(!this.updateitem){
      this.itemService.addItem(this.item).subscribe(value => this.addedItem = value );
    }
    else{
      this.itemService.updateItem(this.item).subscribe(value => this.addedItem = value)
      this.updateitem = false;
    }
  }

  updateItem(id): void{
    this.updateitem = true;
    this.items.forEach(element => {
      if(element.id == id){
        this.item = element;
      }
    });
    window.scroll(0,0);
  }

  ngOnInit() {
    this.itemService.getAllItems().subscribe(resp => this.items = resp)
  }
  
  ngAfterInit(){
  }

}

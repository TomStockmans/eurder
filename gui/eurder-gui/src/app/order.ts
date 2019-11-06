import { Item } from './item';

export class Order {
     id : string;
     items = [];

    constructor(id, itemgroup){
        this.id = id;
        this.addItems(itemgroup);
    }

    private addItems(itemgroup){

        itemgroup.forEach(element => {
            var itemGroup = {
                "id" : element.item.id,
                "amount" : element.amount
            }
            this.items.push(itemGroup);
            
        });
    }

}

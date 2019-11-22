package be.tomstockmans.eurder.domain.entities.ItemGroup;

import be.tomstockmans.eurder.domain.entities.item.Item;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class ItemGroup {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private int amount;
    private LocalDate shippingDate;

    public ItemGroup(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        calculateShippingDate();
    }

    public ItemGroup() {

    }

    private void calculateShippingDate() {
        if(item.getAmount() - amount >= 0){
            this.shippingDate = LocalDate.now().plus(1, ChronoUnit.DAYS);
        }
        else {
            this.shippingDate = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        }

    }

    public UUID getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double totalPrice(){
        return amount*item.getPrice();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setShippingDate(LocalDate shippingDate) {
        if(item.getAmount() > 0){
            this.shippingDate = LocalDate.now().plus(1, ChronoUnit.DAYS);
        }
        else {
            this.shippingDate = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        }
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
                "id=" + id +
                ", item=" + item +
                ", amount=" + amount +
                ", shippingDate=" + shippingDate +
                '}';
    }
}

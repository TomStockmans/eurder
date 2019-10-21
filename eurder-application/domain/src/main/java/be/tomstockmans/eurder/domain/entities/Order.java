package be.tomstockmans.eurder.domain.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ORDER_ID")
    private List<ItemGroup> items;
    private double totalPrice;

    private UUID userId;


    public Order(List<ItemGroup> items, UUID userId) {
        this.items = items;
        this.userId = userId;
        calculateTotalPrice();
    }

    public Order() {
    }

    private void calculateTotalPrice() {

        this.totalPrice = items.stream().mapToDouble(ItemGroup::totalPrice).sum();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setItems(List<ItemGroup> items) {
        this.items = items;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", userId=" + userId +
                '}';
    }
}

package be.tomstockmans.eurder.domain.entities.item;

import java.util.Objects;
import java.util.UUID;

public class ItemDtoResponse {
    public UUID id;
    public String name;
    public String description;
    public double price;
    public int amount;

    public ItemDtoResponse() {
    }

    public ItemDtoResponse(UUID id, String name, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDtoResponse response = (ItemDtoResponse) o;
        return Double.compare(response.price, price) == 0 &&
                amount == response.amount &&
                Objects.equals(id, response.id) &&
                Objects.equals(name, response.name) &&
                Objects.equals(description, response.description);
    }

}

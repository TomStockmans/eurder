package be.tomstockmans.eurder.domain.dto;

import java.util.UUID;

public class ItemDto {
    public UUID id;
    public String name;
    public String description;
    public double price;
    public int amount;

    public ItemDto() {
    }

    public ItemDto(UUID id, String name, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}

package be.tomstockmans.eurder.domain.entities.item;

import java.util.UUID;

public class ItemInOrderResponseDto {

    public UUID id;
    public String name;
    public String description;
    public double price;

    public ItemInOrderResponseDto(UUID id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

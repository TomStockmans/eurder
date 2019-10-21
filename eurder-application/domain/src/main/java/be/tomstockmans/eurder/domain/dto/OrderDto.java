package be.tomstockmans.eurder.domain.dto;

import be.tomstockmans.eurder.domain.entities.ItemGroup;
import be.tomstockmans.eurder.domain.entities.User;

import java.util.List;
import java.util.UUID;

public class OrderDto {

    public UUID id;
    public List<ItemGroup> items;
    public double totalPrice;
    public UUID userId;

    public OrderDto(UUID id, List<ItemGroup> items, double totalPrice,UUID userId) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
        this.userId = userId;
    }
}

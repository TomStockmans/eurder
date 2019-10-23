package be.tomstockmans.eurder.domain.entities.Order;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroup;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoResponse;

import java.util.List;
import java.util.UUID;

public class OrderDtoResponse {

    public UUID id;
    public List<ItemGroupDtoResponse> items;
    public double totalPrice;


    public OrderDtoResponse(UUID id, List<ItemGroupDtoResponse> items, double totalPrice) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public OrderDtoResponse() {
    }
}

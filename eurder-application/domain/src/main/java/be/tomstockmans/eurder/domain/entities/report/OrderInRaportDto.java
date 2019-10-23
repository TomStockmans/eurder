package be.tomstockmans.eurder.domain.entities.report;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoResponse;

import java.util.List;
import java.util.UUID;

public class OrderInRaportDto {
    public UUID orderId;
    public List<ItemGroupDtoResponse> items;
    public double totalPrice;

    public OrderInRaportDto(UUID orderId, List<ItemGroupDtoResponse> items, double totalPrice) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = totalPrice;
    }
}

package be.tomstockmans.eurder.domain.entities.ItemGroup;

import be.tomstockmans.eurder.domain.entities.item.Item;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import be.tomstockmans.eurder.domain.entities.item.ItemInOrderResponseDto;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupDtoResponse {

    public ItemInOrderResponseDto item;
    public int amount;
    public LocalDate shippingDate;

    public ItemGroupDtoResponse(ItemInOrderResponseDto item, int amount, LocalDate shippingDate) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public ItemGroupDtoResponse() {

    }
}

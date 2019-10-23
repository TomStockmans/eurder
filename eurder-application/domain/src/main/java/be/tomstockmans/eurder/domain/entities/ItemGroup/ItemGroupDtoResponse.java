package be.tomstockmans.eurder.domain.entities.ItemGroup;

import be.tomstockmans.eurder.domain.entities.item.Item;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupDtoResponse {

    public ItemDtoResponse item;
    public int amount;
    public LocalDate shippingDate;

    public ItemGroupDtoResponse(ItemDtoResponse item, int amount, LocalDate shippingDate) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public ItemGroupDtoResponse() {

    }
}

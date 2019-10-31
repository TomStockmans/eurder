package be.tomstockmans.eurder.domain.entities.Order;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroup;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoRequest;

import java.util.List;
import java.util.UUID;

public class CreateOrderDto {

    public UUID userId;
    public List<ItemGroupDtoRequest> items;
    //public UUID userId;

    public CreateOrderDto(UUID userId, List<ItemGroupDtoRequest> items){
        this.items = items;
        //this.userId = userId;
    }

    public CreateOrderDto() {
    }

    @Override
    public String toString() {
        return "CreateOrderDto{" +
                "items=" + items +
                '}';
    }
}

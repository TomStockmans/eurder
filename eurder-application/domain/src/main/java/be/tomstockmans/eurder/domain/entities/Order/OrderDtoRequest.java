package be.tomstockmans.eurder.domain.entities.Order;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroup;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoRequest;

import java.util.List;
import java.util.UUID;

public class OrderDtoRequest {

    public UUID userId;
    public List<ItemGroupDtoRequest> items;
    //public UUID userId;

    public OrderDtoRequest(UUID userId, List<ItemGroupDtoRequest> items){
        this.items = items;
        //this.userId = userId;
    }

    public OrderDtoRequest() {
    }

    @Override
    public String toString() {
        return "OrderDtoRequest{" +
                "items=" + items +
                '}';
    }
}

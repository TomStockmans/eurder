package be.tomstockmans.eurder.domain.entities.Order;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupMapper;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderCreatedDto orderToDtoResponse(Order order){
        return new OrderCreatedDto(order.getId(),
                order.getItems().stream().map(o -> ItemGroupMapper.itemGroupToDtoResponse(o)).collect(Collectors.toList()),
                        order.getTotalPrice());
    }

}

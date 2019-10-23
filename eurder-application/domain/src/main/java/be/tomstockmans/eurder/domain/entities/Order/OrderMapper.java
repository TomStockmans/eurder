package be.tomstockmans.eurder.domain.entities.Order;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupMapper;
import be.tomstockmans.eurder.domain.entities.report.OrderInRaportDto;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDtoResponse orderToDtoResponse(Order order){
        return new OrderDtoResponse(order.getId(),
                order.getItems().stream().map(o -> ItemGroupMapper.itemGroupToDtoResponse(o)).collect(Collectors.toList()),
                        order.getTotalPrice());
    }

}

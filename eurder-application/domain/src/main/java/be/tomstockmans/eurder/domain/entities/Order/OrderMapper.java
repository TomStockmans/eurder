package be.tomstockmans.eurder.domain.entities.Order;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderCreatedDto orderToDtoResponse(Order order) {
        return new OrderCreatedDto(order.getId(),
                order.getItems().stream().map(o -> ItemGroupMapper.itemGroupToDtoResponse(o)).collect(Collectors.toList()),
                order.getTotalPrice());
    }

    public static ReportOfOrdersDto ordersToReportDto(List<Order> orders) {
        return new ReportOfOrdersDto(
                orders
                        .stream()
                        .map(o -> new ReportOfOrdersDto.OrderDto(
                                    o.getId(),
                                    o.getItems()
                                            .stream()
                                            .map(ig -> new ReportOfOrdersDto.ItemGroupDto(ig.getItem().getName(),
                                                    ig.getAmount(),
                                                    ig.getAmount() * ig.getItem().getPrice()))
                                            .collect(Collectors.toList())
                        ))
                        .collect(Collectors.toList())
        );
    }

}

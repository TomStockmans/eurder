package be.tomstockmans.eurder.api.service;

import be.tomstockmans.eurder.api.controller.OrderController;
import be.tomstockmans.eurder.domain.db.ItemRepository;
import be.tomstockmans.eurder.domain.db.OrderRepository;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoRequest;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoResponse;
import be.tomstockmans.eurder.domain.entities.Order.OrderDtoRequest;
import be.tomstockmans.eurder.domain.entities.Order.OrderDtoResponse;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroup;
import be.tomstockmans.eurder.domain.entities.Order.Order;
import be.tomstockmans.eurder.domain.entities.Order.OrderMapper;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static be.tomstockmans.eurder.domain.entities.Order.OrderMapper.*;

@Service
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;


    public OrderDtoResponse addOrder(OrderDtoRequest orderDtoResponse){
        System.out.println(orderDtoResponse);

        List<ItemGroup> itemGroups = orderDtoResponse.items.stream()
                    .map(
                        itemGroupDtoRequest ->
                            new ItemGroup(
                                    itemRepository.findById(itemGroupDtoRequest.id).get(),itemGroupDtoRequest.amount
                            )
                         )
                    .collect(Collectors.toList());


        Order order = new Order(itemGroups, null);
        Order createdOrder = orderRepository.save(order);
        logger.info("added order " + createdOrder.toString());
        return orderToDtoResponse(createdOrder);

    }
}

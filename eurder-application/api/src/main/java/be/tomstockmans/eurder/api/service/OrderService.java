package be.tomstockmans.eurder.api.service;

import be.tomstockmans.eurder.api.controller.OrderController;
import be.tomstockmans.eurder.domain.db.ItemRepository;
import be.tomstockmans.eurder.domain.db.OrderRepository;
import be.tomstockmans.eurder.domain.db.UserRepository;
import be.tomstockmans.eurder.domain.entities.Order.CreateOrderDto;
import be.tomstockmans.eurder.domain.entities.Order.OrderCreatedDto;
import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroup;
import be.tomstockmans.eurder.domain.entities.Order.Order;
import be.tomstockmans.eurder.domain.entities.Order.OrderMapper;
import be.tomstockmans.eurder.domain.entities.User.ROLE;
import be.tomstockmans.eurder.domain.entities.User.User;
import be.tomstockmans.eurder.domain.entities.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static be.tomstockmans.eurder.domain.entities.Order.OrderMapper.*;

@Service
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderRepository orderRepository;

    private ItemRepository itemRepository;

    private UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;

        User user = this.userRepository.save(new User("tom", "stockmans", "tom.stockmans@hotmail.com", "tw wilsonlaan 2", "0496209967","tommeke", ROLE.ADMIN));
        Item item1 = this.itemRepository.save(new Item("item1", "item 1 description", 2.5, 5));
        Item item2 = this.itemRepository.save(new Item("item2", "item 2 description", 3.5, 7));

        Order order1 = this.orderRepository.save(new Order(Arrays.asList(new ItemGroup(item1, 2),new ItemGroup(item2,1)), user.getId()));

    }

    public OrderCreatedDto addOrder(CreateOrderDto orderDtoResponse){
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

    public List<OrderCreatedDto> getAllOrders(){
        List<OrderCreatedDto> orders = new ArrayList<>();
        orderRepository.findAll().forEach(order -> orders.add(OrderMapper.orderToDtoResponse(order)));
        return orders;
    }
}

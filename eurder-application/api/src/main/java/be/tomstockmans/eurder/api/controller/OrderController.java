package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.api.service.OrderService;
import be.tomstockmans.eurder.domain.entities.Order.CreateOrderDto;
import be.tomstockmans.eurder.domain.entities.Order.OrderCreatedDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OrderController.ORDER_CONTROLLER_RESOURCE_URL)
@CrossOrigin
public class OrderController {

    public static final String ORDER_CONTROLLER_RESOURCE_URL = "/orders";
    private Logger logger = LoggerFactory.getLogger(OrderController.class);


    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderCreatedDto addOrder(@RequestBody CreateOrderDto createOrderDto){
        return orderService.addOrder(createOrderDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderCreatedDto> getAllOrders(){
        return orderService.getAllOrders();
    }

}

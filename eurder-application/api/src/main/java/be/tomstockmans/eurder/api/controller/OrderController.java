package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.api.service.OrderService;
import be.tomstockmans.eurder.domain.entities.Order.OrderDtoRequest;
import be.tomstockmans.eurder.domain.entities.Order.OrderDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderController.ORDER_CONTROLLER_RESOURCE_URL)
public class OrderController {

    public static final String ORDER_CONTROLLER_RESOURCE_URL = "/order";
    private Logger logger = LoggerFactory.getLogger(OrderController.class);


    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDtoResponse addOrder(@RequestBody OrderDtoRequest orderDtoRequest){
        return orderService.addOrder(orderDtoRequest);
    }

}

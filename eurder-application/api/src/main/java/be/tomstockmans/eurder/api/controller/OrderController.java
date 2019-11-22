package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.api.service.OrderService;
import be.tomstockmans.eurder.api.service.UserService;
import be.tomstockmans.eurder.domain.entities.Order.CreateOrderDto;
import be.tomstockmans.eurder.domain.entities.Order.OrderCreatedDto;
import be.tomstockmans.eurder.domain.entities.Order.ReportOfOrdersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(OrderController.ORDER_CONTROLLER_RESOURCE_URL)
public class OrderController {

    public static final String ORDER_CONTROLLER_RESOURCE_URL = "/orders";
    private Logger logger = LoggerFactory.getLogger(OrderController.class);


    private OrderService orderService;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {

        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('USER')")
    public OrderCreatedDto addOrder(@RequestBody CreateOrderDto createOrderDto, Principal principal){
        UUID id = userService.findIdFromUserWithMail(principal.getName());
        return orderService.addOrder(id, createOrderDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<OrderCreatedDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('USER')")
    public ReportOfOrdersDto getReportOfOrders(Principal principal){
        UUID id = userService.findIdFromUserWithMail(principal.getName());
        return orderService.getReportForPersonWithId(id);
    }

    @PostMapping("reorder")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('USER')")
    public OrderCreatedDto reOrder(@RequestBody String id, Principal principal){
        UUID orderId = UUID.fromString(id);
        UUID userId = userService.findIdFromUserWithMail(principal.getName());
        return orderService.reOrder(orderId, userId);
    }




}

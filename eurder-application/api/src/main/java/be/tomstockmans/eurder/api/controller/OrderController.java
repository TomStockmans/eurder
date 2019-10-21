package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.db.ItemRepository;
import be.tomstockmans.eurder.domain.dto.OrderDto;
import be.tomstockmans.eurder.domain.entities.ItemGroup;
import be.tomstockmans.eurder.domain.entities.Order;
import be.tomstockmans.eurder.domain.db.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public OrderDto addOrder(@RequestBody OrderDto orderDto){

        List<ItemGroup> itemGroups = new ArrayList<>();
        for (ItemGroup itemGroup: orderDto.items) {
            itemGroups.add(new ItemGroup(
                    itemRepository.findById(itemGroup.getItem().getId()).get(),
                    itemGroup.getAmount()
            ));
        }

        Order order = new Order(itemGroups,orderDto.userId);
        Order createdOrder = orderRepository.save(order);
        logger.info("added order " + createdOrder.toString());
        return new OrderDto(createdOrder.getId(),createdOrder.getItems(),createdOrder.getTotalPrice(),createdOrder.getUserId());
    }

    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Order getOrder(@PathVariable("id") String id){
        return new Order(Arrays.asList(
                new ItemGroup(new Item("test","test",2.5,5),2)
        ));
        /*

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();

        try {

            // get Oraganisation object as a json string
            String jsonStr = Obj.writeValueAsString(new Order(Arrays.asList(
                    new ItemGroup(new Item("test","test",2.5,5),2)
            )));

            // Displaying JSON String
            System.out.println(jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return orderRepository.findById(UUID.fromString(id)).get();



    }*/

}

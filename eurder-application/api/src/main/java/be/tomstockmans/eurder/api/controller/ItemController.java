package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.dto.ItemDto;
import be.tomstockmans.eurder.domain.entities.Item;
import be.tomstockmans.eurder.domain.db.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);
    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public void addItem(@RequestBody ItemDto itemDto) {
        Item item = new Item(itemDto.name, itemDto.description,itemDto.price, itemDto.amount);
        Item savedItem = itemRepository.save(item);
        logger.info("added item " + savedItem.toString());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ItemDto getItem(@PathVariable("id") UUID id){
        Item item =  itemRepository.findById(id).get();
        return new ItemDto(item.getId(),item.getName(),item.getDescription(),item.getPrice(),item.getAmount());

    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateItem(@RequestBody ItemDto itemDto){
        Item item = new Item(itemDto.name,itemDto.description, itemDto.price,itemDto.amount);
        item.setId(itemDto.id);
        Item newitem =  itemRepository.save(item);
        System.out.println(newitem.toString());
        //return newitem;
    }



}

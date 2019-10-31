package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.api.service.ItemService;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoRequest;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(ItemController.ITEM_CONTROLLER_RESOURCE_URL)
public class ItemController {


    public static final String ITEM_CONTROLLER_RESOURCE_URL = "/items";
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDtoResponse addItem(@RequestBody ItemDtoRequest itemDtoRequest) {
        return itemService.addItem(itemDtoRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ItemDtoResponse getItem(@PathVariable("id") UUID id){
       return itemService.getItemById(id);
    }

    //TEST FUNCTION
    @RequestMapping(method = RequestMethod.GET)
    public List<ItemDtoResponse> getAllItem(){
        return itemService.getAllItems();
    }

    @PutMapping("/{id}")
    public ItemDtoResponse updateItem(@RequestBody ItemDtoRequest itemDtoRequest, @PathVariable UUID id){
        return itemService.updateItem(itemDtoRequest, id);
    }



}

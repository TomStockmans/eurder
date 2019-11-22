package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.api.service.ItemService;
import be.tomstockmans.eurder.domain.entities.item.CreateItemDtoRequest;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import be.tomstockmans.eurder.domain.entities.item.ItemThatNeedToBeShippedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(ItemController.ITEM_CONTROLLER_RESOURCE_URL)
@CrossOrigin
public class ItemController {


    public static final String ITEM_CONTROLLER_RESOURCE_URL = "/items";
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ItemDtoResponse addItem(@RequestBody CreateItemDtoRequest createItemDtoRequest) {
        return itemService.addItem(createItemDtoRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public ItemDtoResponse getItem(@PathVariable("id") UUID id){
       return itemService.getItemById(id);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ItemDtoResponse updateItem(@RequestBody CreateItemDtoRequest createItemDtoRequest, @PathVariable UUID id){
        return itemService.updateItem(createItemDtoRequest, id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<ItemDtoResponse> getAllItem(){
        return itemService.getAllItems();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ship")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ItemThatNeedToBeShippedDto> getItemsThatNeedToBeShipped(){
        return itemService.getItemsThatNeedToBeShipped();
    }





}

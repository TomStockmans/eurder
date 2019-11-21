package be.tomstockmans.eurder.api.service;

import be.tomstockmans.eurder.api.controller.ItemController;
import be.tomstockmans.eurder.domain.db.ItemRepository;
import be.tomstockmans.eurder.domain.entities.item.Item;
import be.tomstockmans.eurder.domain.entities.item.CreateItemDtoRequest;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;;
import be.tomstockmans.eurder.domain.entities.item.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static be.tomstockmans.eurder.domain.entities.item.ItemMapper.*;

@Service
public class ItemService {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemRepository itemRepository;

    public ItemDtoResponse addItem(CreateItemDtoRequest createItemDtoRequest){
        Item item = dtoRequestToItem(createItemDtoRequest);
        Item savedItem = itemRepository.save(item);
        logger.info("added item " + savedItem.toString());
        return itemToDtoResponse(savedItem);
    }

    public ItemDtoResponse getItemById(UUID id){
        Item item =  itemRepository.findById(id).get();
        return itemToDtoResponse(item);
    }


    public ItemDtoResponse updateItem(CreateItemDtoRequest createItemDtoRequest, UUID id){
        Item item = dtoRequestToItem(createItemDtoRequest);
        item.setId(id);
        Item newitem =  itemRepository.save(item);
        logger.info("updated item: " + newitem.toString());
        return itemToDtoResponse(newitem);
    }


    public List<ItemDtoResponse> getAllItems() {
        List<ItemDtoResponse> items = new ArrayList<>();
        itemRepository.findAll().forEach(item -> items.add(ItemMapper.itemToDtoResponse(item)));
        return items;
    }
}

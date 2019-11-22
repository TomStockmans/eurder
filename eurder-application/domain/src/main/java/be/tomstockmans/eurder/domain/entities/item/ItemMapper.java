package be.tomstockmans.eurder.domain.entities.item;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroup;
import be.tomstockmans.eurder.domain.entities.User.User;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static Item dtoRequestToItem(CreateItemDtoRequest createItemDtoRequest){
        return new Item(createItemDtoRequest.name, createItemDtoRequest.description, createItemDtoRequest.price, createItemDtoRequest.amount);
    }

    public static ItemDtoResponse itemToDtoResponse(Item item){
        return new ItemDtoResponse(item.getId(),item.getName(),item.getDescription(),item.getPrice(),item.getAmount());
    }

    public static ItemInOrderResponseDto itemToItemInOrderResponseDto(Item item){
        return new ItemInOrderResponseDto(item.getId(), item.getName(), item.getDescription(),item.getPrice());
    }


    public static List<ItemThatNeedToBeShippedDto> itemToItemThatNeedToBeShipedDto(User user) {

        return user.getOrders()
                .stream()
                .map(order ->
                        order.getItems().stream().map(itemGroup ->
                                        new ItemThatNeedToBeShippedDto.ItemGroupDto(
                                                new ItemThatNeedToBeShippedDto.ItemDto(
                                                        itemGroup.getItem().getId(),
                                                        itemGroup.getItem().getAmount(),
                                                        itemGroup.getShippingDate(),

                                                )
                                        )
                                )
                )
                .collect(Collectors.toList());
    }
}

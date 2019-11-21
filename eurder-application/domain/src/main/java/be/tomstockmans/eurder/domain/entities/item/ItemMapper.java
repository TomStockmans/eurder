package be.tomstockmans.eurder.domain.entities.item;

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
}

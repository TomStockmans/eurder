package be.tomstockmans.eurder.domain.entities.item;

public class ItemMapper {

    public static Item dtoRequestToItem(ItemDtoRequest itemDtoRequest){
        return new Item(itemDtoRequest.name, itemDtoRequest.description, itemDtoRequest.price, itemDtoRequest.amount);
    }

    public static ItemDtoResponse itemToDtoResponse(Item item){
        return new ItemDtoResponse(item.getId(),item.getName(),item.getDescription(),item.getPrice(),item.getAmount());
    }
}

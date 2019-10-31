package be.tomstockmans.eurder.domain.entities.ItemGroup;

import be.tomstockmans.eurder.domain.entities.item.ItemMapper;

public class ItemGroupMapper {

    public static ItemGroupDtoResponse itemGroupToDtoResponse(ItemGroup itemGroup){
        return new ItemGroupDtoResponse(ItemMapper.itemToItemInOrderResponseDto(itemGroup.getItem()), itemGroup.getAmount(), itemGroup.getShippingDate());
    }

    public static  ItemGroup DtoRequestToItemGroup(ItemGroupDtoRequest itemGroupDtoRequest){
        return new ItemGroup();
    }
}

package be.tomstockmans.eurder.domain.entities.item;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ItemThatNeedToBeShippedDto {

    public List<ItemGroupDto> itemGroups;

    public ItemThatNeedToBeShippedDto(List<ItemGroupDto> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public static class ItemGroupDto{
        public ItemDto item;
        public int amount;
        public LocalDate shippingDate;
        public String adress;

        public ItemGroupDto(ItemDto item, int amount, LocalDate shippingDate, String adress) {
            this.item = item;
            this.amount = amount;
            this.shippingDate = shippingDate;
            this.adress = adress;
        }
    }

    public static class ItemDto{
        public UUID id;
        public String name;
        public double price;

        public ItemDto(UUID id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

}

package be.tomstockmans.eurder.domain.entities.Order;

import java.util.List;
import java.util.UUID;

public class ReportOfOrdersDto {

    public List<OrderDto> orders;
    public double totalPriceOfAllOrders;

    public ReportOfOrdersDto(List<OrderDto> orders) {
        this.orders = orders;
        this.totalPriceOfAllOrders = orders
                .stream()
                .mapToDouble(o -> o.totalPriceOrder)
                .sum();
    }

    public static class ItemGroupDto {
        public String name;
        public int amount;
        public double totalPrice;

        public ItemGroupDto(String name, int amount, double totalPrice) {
            this.name = name;
            this.amount = amount;
            this.totalPrice = totalPrice;
        }
    }

    public  static class OrderDto {
        public UUID orderId;
        public List<ItemGroupDto> itemGroups;
        public double totalPriceOrder;

        public OrderDto(UUID orderId, List<ItemGroupDto> itemGroups) {
            this.orderId = orderId;
            this.itemGroups = itemGroups;
            this.totalPriceOrder = itemGroups
                    .stream()
                    .mapToDouble(i -> i.totalPrice)
                    .sum();
        }
    }

}

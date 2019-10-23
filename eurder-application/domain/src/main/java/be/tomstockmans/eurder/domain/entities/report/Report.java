package be.tomstockmans.eurder.domain.entities.report;

import be.tomstockmans.eurder.domain.entities.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<Order> orders = new ArrayList<>();
    private double totalePriceOrders;

    public Report(List<Order> orders, double totalePriceOrders) {
        this.orders = orders;
        this.totalePriceOrders = totalePriceOrders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getTotalePriceOrders() {
        return totalePriceOrders;
    }
}

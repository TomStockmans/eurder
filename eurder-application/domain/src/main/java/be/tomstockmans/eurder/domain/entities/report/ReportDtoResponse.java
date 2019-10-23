package be.tomstockmans.eurder.domain.entities.report;

import java.util.ArrayList;
import java.util.List;

public class ReportDtoResponse {
        public List<OrderInRaportDto> orders = new ArrayList<>();
        public double totalPriceAllOrders;

    public ReportDtoResponse(List<OrderInRaportDto> orders, double totalPriceAllOrders) {
        this.orders = orders;
        this.totalPriceAllOrders = totalPriceAllOrders;
    }
}

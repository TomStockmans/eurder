package be.tomstockmans.eurder.domain.entities.report;

public class ReportMapper {

    public static ReportDtoResponse reportToDtoResponse(Report report){
        return new ReportDtoResponse(null,report.getTotalePriceOrders());
    }
}

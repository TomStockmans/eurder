package be.tomstockmans.eurder.domain.entities.item;

public class CreateItemDtoRequest {

    public String name;
    public String description;
    public double price;
    public int amount;

    public CreateItemDtoRequest() {

    }

    public CreateItemDtoRequest(String name, String description, double price, int amount) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}

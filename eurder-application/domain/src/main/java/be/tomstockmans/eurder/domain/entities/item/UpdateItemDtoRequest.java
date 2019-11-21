package be.tomstockmans.eurder.domain.entities.item;

import java.util.UUID;

public class UpdateItemDtoRequest {
    public UUID uuid;
    public String name;
    public String description;
    public double price;
    public int amount;
}

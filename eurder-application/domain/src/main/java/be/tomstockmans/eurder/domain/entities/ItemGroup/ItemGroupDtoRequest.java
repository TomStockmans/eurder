package be.tomstockmans.eurder.domain.entities.ItemGroup;

import java.util.UUID;

public class ItemGroupDtoRequest {
    public UUID id;
    public int amount;

    public ItemGroupDtoRequest(UUID id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ItemGroupDtoRequest{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}

package be.tomstockmans.eurder.domain.db;

import be.tomstockmans.eurder.domain.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {

}

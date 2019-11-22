package be.tomstockmans.eurder.domain.db;

import be.tomstockmans.eurder.domain.entities.User.User;
import be.tomstockmans.eurder.domain.entities.item.Item;
import be.tomstockmans.eurder.domain.entities.item.ItemThatNeedToBeShippedDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {


}

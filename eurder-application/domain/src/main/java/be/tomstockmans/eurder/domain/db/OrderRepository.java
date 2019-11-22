package be.tomstockmans.eurder.domain.db;

import be.tomstockmans.eurder.domain.entities.Order.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface OrderRepository extends CrudRepository<Order, UUID> {

    List<Order> findAllByUserId(UUID uuid);
}

package be.tomstockmans.eurder.domain.db;
import be.tomstockmans.eurder.domain.entities.User.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface UserRepository extends CrudRepository<User, UUID> {

}

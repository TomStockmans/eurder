package be.tomstockmans.eurder.domain.db;
import be.tomstockmans.eurder.domain.entities.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
        default User findByUserName(String username){
            List<User> list = new ArrayList<>();
            this.findAll().iterator().forEachRemaining(list::add);
            return list.stream().filter(user -> user.getUsername().equals(username)).findAny().orElseThrow(() ->new IllegalArgumentException("probleempje"));

        }

        User findByEmailEquals(String email);
}

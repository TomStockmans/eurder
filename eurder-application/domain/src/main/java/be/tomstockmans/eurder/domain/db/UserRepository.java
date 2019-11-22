package be.tomstockmans.eurder.domain.db;

import be.tomstockmans.eurder.domain.entities.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

        User findByEmailEquals(String email);

        List<User> findAll();



}

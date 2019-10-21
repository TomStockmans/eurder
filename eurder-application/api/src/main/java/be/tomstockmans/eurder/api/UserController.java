package be.tomstockmans.eurder.api;

import be.tomstockmans.eurder.domain.entities.User;
import be.tomstockmans.eurder.domain.db.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void addUser(@RequestBody User user){

        try {

            User addedUser = userRepository.save(user);
            logger.info("user added " + addedUser.toString());

        }catch (Exception e){
           logger.error(e.getMessage());
        }

    }

}

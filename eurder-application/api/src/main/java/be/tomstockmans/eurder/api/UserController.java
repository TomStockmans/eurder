package be.tomstockmans.eurder.api;

import be.tomstockmans.eurder.domain.User;
import be.tomstockmans.eurder.domain.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {


    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){

        try {
            userRepository.save(user);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

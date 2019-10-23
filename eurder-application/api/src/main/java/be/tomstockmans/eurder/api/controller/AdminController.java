package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.db.UserRepository;
import be.tomstockmans.eurder.domain.entities.User.User;
import be.tomstockmans.eurder.domain.entities.User.UserDto;
import be.tomstockmans.eurder.domain.entities.User.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping(AdminController.ADMIN_CONTROLLER_RESOURCE_URL)
public class AdminController {

    public static final String ADMIN_CONTROLLER_RESOURCE_URL = "/admin";
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/customers")
    public List<UserDto> getAllCustomers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u -> users.add(u));
        return UserMapper.multipleUserstoDto(users);
    }
}

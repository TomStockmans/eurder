package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.db.UserRepository;
import be.tomstockmans.eurder.domain.entities.User.User;
import be.tomstockmans.eurder.domain.entities.User.UserCreatedResponseDto;
import be.tomstockmans.eurder.domain.entities.User.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AdminController.ADMIN_CONTROLLER_RESOURCE_URL)
public class AdminController {

    public static final String ADMIN_CONTROLLER_RESOURCE_URL = "/admins";
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserCreatedResponseDto> getAllCustomers(){
        System.out.println("in c");
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u -> users.add(u));
        return UserMapper.multipleUserstoDto(users);
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserCreatedResponseDto getCustomerWithId(@PathVariable UUID id){
        System.out.println("in c");
        return UserMapper.userToDto(userRepository.findById(id).get());
    }
}

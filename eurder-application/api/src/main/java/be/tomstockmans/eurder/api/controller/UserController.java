package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.api.service.UserService;
import be.tomstockmans.eurder.domain.entities.User.CreateUserDto;
import be.tomstockmans.eurder.domain.entities.User.UserCreatedResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreatedResponseDto addUser(@RequestBody CreateUserDto createUserDto) {
        return userService.addUser(createUserDto);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserCreatedResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserCreatedResponseDto getUserWithId(@PathVariable UUID id) {
        return userService.getUserById(id);

    }

}

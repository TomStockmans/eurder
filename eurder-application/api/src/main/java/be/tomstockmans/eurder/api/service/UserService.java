package be.tomstockmans.eurder.api.service;

import be.tomstockmans.eurder.domain.db.UserRepository;
import be.tomstockmans.eurder.domain.entities.User.CreateUserDto;
import be.tomstockmans.eurder.domain.entities.User.User;
import be.tomstockmans.eurder.domain.entities.User.UserCreatedResponseDto;
import be.tomstockmans.eurder.domain.entities.User.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCreatedResponseDto addUser(CreateUserDto userDto) {
        try {
            User addedUser = userRepository.save(UserMapper.ceateUserDtoToUser(userDto));
            logger.info("user added " + addedUser.toString());
            return UserMapper.userToDto(addedUser);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    public List<UserCreatedResponseDto> getAllUsers() {
        List<UserCreatedResponseDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(UserMapper.userToDto(user)));
        return users;
    }

    public UserCreatedResponseDto getUserById(UUID id) {
        return UserMapper.userToDto(userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}

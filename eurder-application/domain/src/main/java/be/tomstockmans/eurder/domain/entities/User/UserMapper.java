package be.tomstockmans.eurder.domain.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserCreatedResponseDto userToDto(User user) {
        return new UserCreatedResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAdress(), user.getPhoneNumber());
    }

    public static List<UserCreatedResponseDto> multipleUserstoDto(List<User> users) {

        return users.stream().map(UserMapper::userToDto).collect(Collectors.toList());

    }

    public static User ceateUserDtoToUser(CreateUserDto createUserDto) {
        return new User(createUserDto.firstName,
                createUserDto.lastName,
                createUserDto.email,
                createUserDto.adress,
                createUserDto.phoneNumber,
                createUserDto.password,
                createUserDto.role
        );

    }
}

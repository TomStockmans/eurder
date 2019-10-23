package be.tomstockmans.eurder.domain.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto usertoDto(User user){
        return new UserDto(user.getFirstName(),user.getLastName(),user.getEmail(),user.getAdress(),user.getPhoneNumber());
    }

    public static List<UserDto> multipleUserstoDto(List<User> users){

        return users.stream().map(UserMapper::usertoDto).collect(Collectors.toList());

    }
}

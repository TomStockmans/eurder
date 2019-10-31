package be.tomstockmans.eurder.domain.entities.User;

import java.util.UUID;

public class UserCreatedResponseDto {

    public UUID id;
    public String firstName;
    public String lastName;
    public String email;
    public String adress;
    public String phoneNumber;

    public UserCreatedResponseDto(UUID id, String firstName, String lastName, String email, String adress, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}

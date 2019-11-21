package be.tomstockmans.eurder.domain.entities.User;

import java.util.UUID;

public class CreateUserDto {

    public String firstName;
    public String lastName;
    public String email;
    public String adress;
    public String phoneNumber;
    public String password;
    public ROLE     role;

    public CreateUserDto(String firstName, String lastName, String email, String adress, String phoneNumber, String password, ROLE role) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}

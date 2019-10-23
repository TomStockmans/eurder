package be.tomstockmans.eurder.domain.entities.User;

public class UserDto {

    public String firstName;
    public String lastName;
    public String email;
    public String adress;
    public String phoneNumber;

    public UserDto(String firstName, String lastName, String email, String adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}

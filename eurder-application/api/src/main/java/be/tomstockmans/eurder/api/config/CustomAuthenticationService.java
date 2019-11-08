package be.tomstockmans.eurder.api.config;

import be.tomstockmans.eurder.api.service.UserService;
import be.tomstockmans.eurder.domain.entities.User.ExternalAuthentication;
import be.tomstockmans.eurder.domain.entities.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomAuthenticationService {


    private final PasswordEncoder passwordEncoder;
    private UserService userService;
    private List<ExternalAuthentication> externalAuthentications;


    @Autowired
    public CustomAuthenticationService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        //this.externalAuthentications = new ArrayList<>();
    }

//    private ArrayList<ExternalAuthentication> defaultUsers() {
//        ArrayList<ExternalAuthentication> externalAuthentications = new ArrayList<>();
//        externalAuthentications.add(new ExternalAuthentication().withUsername("tom").withPassword(passwordEncoder.encode("tom")).withRoles("meester"));
//        return externalAuthentications;
//    }


    public ExternalAuthentication getUser(String username, String rawPassword) {
        User user = userService.findUserByUsername(username);
        if(passwordEncoder.matches(rawPassword, user.getPassword())){
            return user;
        };
        return null;

//        return externalAuthentications.stream()
//                .filter(externalAuthentication -> externalAuthentication.getUsername().equals(username))
//                .filter(externalAuthentication -> passwordEncoder.matches(rawPassword, externalAuthentication.getPassword()))
//                .findFirst()
//                .orElse(null);
    }
}

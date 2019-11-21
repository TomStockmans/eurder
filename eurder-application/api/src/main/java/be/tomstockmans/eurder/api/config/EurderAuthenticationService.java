package be.tomstockmans.eurder.api.config;

import be.tomstockmans.eurder.domain.entities.User.ExternalAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EurderAuthenticationService  implements AuthenticationProvider {


    private final CustomAuthenticationService customAuthenticationService;

    @Autowired
    public EurderAuthenticationService(CustomAuthenticationService customAuthenticationService) {
        this.customAuthenticationService = customAuthenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ExternalAuthentication user = customAuthenticationService.getUser(authentication.getPrincipal().toString(), authentication.getCredentials().toString());
        if(user != null){
            return new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    rolesToGrantedAuthorities(user.getRole()));
        }
        throw new BadCredentialsException("The provided credentials were invalid.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private Collection<? extends GrantedAuthority> rolesToGrantedAuthorities(String role) {
        List<String> lijst = new ArrayList<>();
        lijst.add(role);
        return lijst.stream()
                .map(s -> new SimpleGrantedAuthority(s))
                .collect(Collectors.toList());
    }
}

package be.tomstockmans.eurder.api;

import be.tomstockmans.eurder.domain.db.UserRepository;
import be.tomstockmans.eurder.domain.entities.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "be.tomstockmans")
@EnableJpaRepositories("be.tomstockmans.eurder.domain.db")
@EntityScan(basePackages = "be.tomstockmans")
//@CrossOrigin
public class EurderApplication {

	public static void main(String[] args) {
		//UserRepository userRepository;
		//userRepository.save(new User("tom","stockmans","tom.st@hotmail.com", "tw wilsonlaan 2c",""));
		SpringApplication.run(EurderApplication.class, args);
	}

//	@Autowired
//	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo){
//		try {
//			builder.userDetailsService(username -> new CustomUserDetails(repo.findByUserName(username)));
//		}catch (Exception e){
//
//		}
//	}

}

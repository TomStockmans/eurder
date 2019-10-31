package be.tomstockmans.eurder.api;

import be.tomstockmans.eurder.domain.db.UserRepository;
import be.tomstockmans.eurder.domain.entities.User.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "be.tomstockmans")
@EnableJpaRepositories("be.tomstockmans.eurder.domain.db")
@EntityScan(basePackages = "be.tomstockmans")
public class EurderApplication {

	public static void main(String[] args) {
		//UserRepository userRepository;
		//userRepository.save(new User("tom","stockmans","tom.st@hotmail.com", "tw wilsonlaan 2c",""));
		SpringApplication.run(EurderApplication.class, args);
	}

}

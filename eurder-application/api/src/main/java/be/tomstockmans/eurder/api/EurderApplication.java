package be.tomstockmans.eurder.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "be.tomstockmans")
@EnableJpaRepositories("be.tomstockmans.eurder.domain.db")
@EntityScan(basePackages = "be.tomstockmans")
public class EurderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurderApplication.class, args);
	}

}

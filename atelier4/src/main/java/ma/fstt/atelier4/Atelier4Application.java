package ma.fstt.atelier4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.fstt.persistence")
@EnableJpaRepositories(basePackages = "ma.fstt.repo")
@ComponentScan(basePackages = "ma.fstt.service")
@ComponentScan(basePackages = "ma.fstt.controller")
public class Atelier4Application {

	public static void main(String[] args) {
		SpringApplication.run(Atelier4Application.class, args);
	}

}

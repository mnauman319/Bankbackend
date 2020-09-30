package dev.nauman.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.nauman.entities.Customer;
import dev.nauman.repositories.CustomerRepository;

@SpringBootApplication
@EntityScan("dev.nauman.entities")
@ComponentScan("dev.nauman")
@EnableJpaRepositories("dev.nauman.repositories")
public class SimpleBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBankApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository repository) {
		return args ->{
			repository.save(new Customer(0,"Dan","password"));
		};
	}
	
}

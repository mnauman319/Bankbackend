package dev.nauman.app;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.nauman.entities.Account;
import dev.nauman.entities.Customer;
import dev.nauman.services.AccountServiceImpl;
import dev.nauman.services.CustomerServiceImpl;

@SpringBootApplication
@EntityScan("dev.nauman.entities")
@ComponentScan("dev.nauman")
@EnableJpaRepositories("dev.nauman.repositories")
public class SimpleBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleBankApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerServiceImpl cserve,AccountServiceImpl aserve) {
		return args ->{
			 cserve.createCustomer(new Customer(0,"Dan","password"));
			 cserve.createCustomer(new Customer(0,"Mike","password"));
			 cserve.createCustomer(new Customer(0,"Rogger","password",true));
			aserve.createAccount(new Account(0, 1, "My Savings", 14000));
			aserve.createAccount(new Account(0, 1, "My Checking", 140));
			aserve.createAccount(new Account(0, 2, "My Savings", 21000));
			aserve.createAccount(new Account(0, 2, "My Checking", 2400));
			aserve.createAccount(new Account(0, 2, "My Vacaction Fund", 10000));
		};
	}
	
}

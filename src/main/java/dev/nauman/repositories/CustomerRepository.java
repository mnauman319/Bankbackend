package dev.nauman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.nauman.entities.Customer;

@Component
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	Customer findCustomerByUsernameAndPassword(String username, String password);
}

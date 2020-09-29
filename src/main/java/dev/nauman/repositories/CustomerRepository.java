package dev.nauman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.nauman.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}

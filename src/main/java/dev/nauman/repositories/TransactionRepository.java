package dev.nauman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.nauman.entities.Transaction;

@Repository
@Component
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}

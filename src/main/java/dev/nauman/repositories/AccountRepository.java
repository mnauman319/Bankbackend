package dev.nauman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.nauman.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{

}

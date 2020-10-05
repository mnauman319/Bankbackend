package dev.nauman.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.nauman.entities.Account;

@Component
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{

	public List<Account> findByBalanceLessThan(double balance);
	public List<Account> findByBalanceGreaterThan(double balance);
	public List<Account> findByBalanceLessThanAndBalanceGreaterThan(double balance1,double balance2);
}

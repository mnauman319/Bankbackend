package dev.nauman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nauman.entities.Account;
import dev.nauman.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository arepo;
	
	@Override
	public Account createAccount(Account account) {
		return arepo.save(account);
	}

	@Override
	public Account getAccountById(int id) {
		return arepo.findById(id).get();
	}

	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) arepo.findAll();
	}

	@Override
	public Account updateAccount(Account account) {
		return arepo.save(account);
	}

	@Override
	public boolean deleteAccountById(int id) {
		arepo.deleteById(id);
		return true;
	}

	@Override
	public boolean deleteAccount(Account account) {
		arepo.delete(account);
		return true;
	}

	@Override
	public List<Account> getGreaterThan(double value) {
		return arepo.findByBalanceGreaterThan(value);
	}

	@Override
	public List<Account> getLessThan(double value) {
		return arepo.findByBalanceLessThan(value);
	}

	@Override
	public List<Account> getGreaterThanAndLessThan(double lValue, double hValue) {
		return arepo.findByBalanceLessThanAndBalanceGreaterThan(lValue,hValue);
	}

	
}

package dev.nauman.services;

import java.util.List;

import dev.nauman.entities.Account;

public interface AccountService {

	Account createAccount(Account account);
	
	Account getAccountById(int id);
	List<Account> getAllAccounts();
	List<Account> getGreaterThan(double value);
	List<Account> getLessThan(double value);
	List<Account> getGreaterThanAndLessThan(double lValue,double hValue);
	
	Account updateAccount(Account account);
	
	boolean deleteAccountById(int id);
	boolean deleteAccount(Account account);
}

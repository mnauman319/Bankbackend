package dev.nauman.services;

import java.util.Set;

import dev.nauman.entities.Account;

public interface AccountService {

	Account createAccount(Account account);
	
	Account getAccountById(int id);
	Set<Account> getAllAccounts();
	
	Account updateAccount(Account account);
	
	boolean deleteAccountById(int id);
	boolean deleteAccount(Account account);
}

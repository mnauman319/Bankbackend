package dev.nauman.services;

import java.util.List;

import dev.nauman.entities.Account;
import dev.nauman.entities.Transaction;

public interface TransactionService {

	Transaction createTransaction(Account accountBefore, Account accountAfter);
	
	Transaction saveTransaction(Transaction transaction);
	
	Transaction getTransactionById(int tId);
	List<Transaction> getAllTransactions();
}

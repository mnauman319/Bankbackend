package dev.nauman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.nauman.entities.Account;
import dev.nauman.entities.Transaction;
import dev.nauman.repositories.TransactionRepository;

@Component
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository trepo;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return trepo.save(transaction);
	}

	@Override
	public Transaction getTransactionById(int tId) {
		return trepo.findById(tId).get();
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return (List<Transaction>) trepo.findAll();
	}

	@Override
	public Transaction createTransaction(Account accountBefore, Account accountAfter) {
		
		if(accountBefore.getBalance() != accountAfter.getBalance()) {
			Transaction transaction = new Transaction(0, accountAfter, accountBefore.getBalance(), accountAfter.getBalance());
			return this.saveTransaction(transaction);
		}
		
		return null;
	}

}

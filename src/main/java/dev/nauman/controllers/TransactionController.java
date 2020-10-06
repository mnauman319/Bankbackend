package dev.nauman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.nauman.entities.Transaction;
import dev.nauman.services.TransactionServiceImpl;

@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TransactionController {

	@Autowired
	TransactionServiceImpl tserv;
	
	@RequestMapping(value = "/transactions",method = RequestMethod.GET)
	public List<Transaction> getAllTransactions(){
		return tserv.getAllTransactions();
	}
	
}

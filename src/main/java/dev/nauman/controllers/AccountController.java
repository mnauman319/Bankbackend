package dev.nauman.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.nauman.entities.Account;
import dev.nauman.entities.Customer;
import dev.nauman.services.AccountServiceImpl;
import dev.nauman.services.CustomerServiceImpl;

@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AccountController {

	@Autowired
	AccountServiceImpl aserv;
	@Autowired
	CustomerServiceImpl cserv;
	
	@RequestMapping(value = "customers/{cId}/accounts", method = RequestMethod.GET)
	public List<Account> getAllAccounts(@PathVariable Integer cId,@RequestParam(required = false) Integer balancegreaterthan, @RequestParam(required = false) Integer balancelessthan){
		List<Account> accounts = null; 
		Customer customer = cserv.getCustomerById(cId);
		
		if(balancegreaterthan == null && balancelessthan == null) {
			accounts = aserv.getAllAccounts();
		}else {
			if(balancegreaterthan != null && balancelessthan == null) {
				accounts = aserv.getGreaterThan(balancegreaterthan);
			}else if(balancegreaterthan == null && balancelessthan != null) {
				accounts = aserv.getLessThan(balancelessthan);
			}else if(balancegreaterthan != null && balancelessthan != null) {
				accounts = aserv.getGreaterThanAndLessThan(balancelessthan, balancegreaterthan);
			}
		}
		if(!customer.isManager()) {
			List<Account> customersAccounts = new ArrayList<Account>();
			for(Account account : accounts) {
				
				if(account.getcId() == cId) {
					customersAccounts.add(account);
				}
			}
			return customersAccounts;
		}
		
		return accounts;
	}
	@RequestMapping(value = "customers/{cId}/accounts/{aId}",method = RequestMethod.GET)
	public Account getAccountById(@PathVariable Integer cId, @PathVariable Integer aId) {
		return aserv.getAccountById(aId);
	}
	@RequestMapping(value = "customers/{cId}/accounts", method = RequestMethod.POST)
	public Account createAccount(@RequestBody Account account,@PathVariable Integer cId) {
		account.setcId(cId);
		return aserv.createAccount(account);
	}
	@RequestMapping(value = "customers/{cId}/accounts", method = RequestMethod.PUT)
	public Account updateAccount(@RequestBody Account account) {
		return aserv.updateAccount(account);
	}
	@RequestMapping(value = "customers/{cId}/accounts/{aId}", method = RequestMethod.DELETE)
	public boolean deleteAccount(@PathVariable Integer aId) {
		return aserv.deleteAccountById(aId);
	}

}

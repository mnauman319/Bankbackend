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

import dev.nauman.entities.Customer;
import dev.nauman.services.AccountService;
import dev.nauman.services.CustomerService;

@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {

	@Autowired
	CustomerService cserv;
	@Autowired
	AccountService aserv;
	
	@RequestMapping(value = "/customers",method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		for(Customer c : cserv.getAllCustomers()) {
			Customer customer = new Customer(c.getcId(), c.getUsername(), c.getPassword(), c.isManager());
			customers.add(customer);
		}
		return customers;
	}
	@RequestMapping(value = "/customers/{id}",method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable Integer id) {
		Customer c = cserv.getCustomerById(id);
		Customer customer = new Customer(c.getcId(), c.getUsername(), c.getPassword(), c.isManager());
		return customer;
	}
	@RequestMapping(value = "/customers",method = RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		return cserv.createCustomer(customer);
	}
	@RequestMapping(value = "/customers",method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return cserv.updateCustomer(customer);
	}
	@RequestMapping(value = "/customers",method = RequestMethod.DELETE)
	public boolean deleteCustomer(@RequestBody Customer customer) {
		return cserv.deleteCustomerByCustomer(customer);
	}
	@RequestMapping(value = "/customers/{id}",method = RequestMethod.DELETE)
	public boolean deleteCustomerById(@PathVariable Integer id) {
		return cserv.deleteCustomerById(id);
	}
	@RequestMapping(value = "customers/login",method = RequestMethod.GET)
	public Customer loginCustomer(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		Customer c = cserv.getCustomerByUsernameAndPassword(username, password);
		Customer customer = new Customer(c.getcId(), c.getUsername(), c.getPassword(), c.isManager());
		return customer;
	}
}

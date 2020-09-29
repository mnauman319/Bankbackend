package dev.nauman.services;

import java.util.Set;

import dev.nauman.entities.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);
	
	Customer getCustomerById(int id);
	Set<Customer> getAllCustomers();
	
	Customer updateCustomer(Customer customer);
	
	boolean deleteCustomerById(int id);
	boolean deleteCustomerByCustomer(Customer customer);
}

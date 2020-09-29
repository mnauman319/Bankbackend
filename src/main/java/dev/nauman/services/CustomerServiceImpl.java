package dev.nauman.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nauman.entities.Customer;
import dev.nauman.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository crepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return crepo.save(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return crepo.findById(id).get();
	}

	@Override
	public Set<Customer> getAllCustomers() {
		return (Set<Customer>) crepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return crepo.save(customer);
	}

	@Override
	public boolean deleteCustomerById(int id) {
		crepo.delete(this.getCustomerById(id));
		return true;
	}

	@Override
	public boolean deleteCustomerByCustomer(Customer customer) {
		crepo.delete(customer);
		return true;
	}
	
}

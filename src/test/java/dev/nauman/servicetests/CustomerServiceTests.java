package dev.nauman.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import dev.nauman.entities.Customer;
import dev.nauman.services.CustomerServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
class CustomerServiceTests {

	@Autowired
	CustomerServiceImpl cserv;
	
	@Test
	@Order(1)
	void createCustomerTest() {
		Customer customer = new Customer(0, "Mike99", "password123");
		customer = cserv.createCustomer(customer);
		assertNotEquals(0, customer.getcId());
		customer = new Customer(0, "Sarah19", "123password");
		customer = cserv.createCustomer(customer);
		assertNotEquals(0, customer.getcId());
	}
	@Test
	@Order(2)
	void getCustomerByIdTest() {
		Customer customer = cserv.getCustomerById(1);
		assertEquals("Mike99", customer.getUsername());
	}
	@Test
	@Order(3)
	void getAllCustomersTest() {
		Set<Customer> customers = cserv.getAllCustomers();
		assertEquals(2, customers.size());
	}
	@Test
	@Order(4)
	void updateCustomerTest() {
		Customer customer = new Customer(1, "Mike13", "wordpass321");
		customer = cserv.updateCustomer(customer);
		assertEquals("Mike13", customer.getUsername());
	}
	@Test
	@Order(5)
	void deleteCustomerByIdTest() {
		assertTrue(cserv.deleteCustomerById(1));
	}
	@Test
	@Order(6)
	void deleteCustomerByCustomerTest() {
		assertTrue(cserv.deleteCustomerByCustomer(cserv.getCustomerById(2)));
	}

}

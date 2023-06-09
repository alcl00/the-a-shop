package com.shop.shoppingapp.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000") //Front-end origin
@RequestMapping(path = "/api/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.findAllCustomers();
	}
	
	@GetMapping(path = "{customerID}")
	public Customer getCustomerById(@PathVariable("customerID") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping
	public void addNewCustomer(@RequestBody Customer customer) {
		customerService.addNewCustomer(customer);
	}
	
	@DeleteMapping(path = "{customerID}")
	public void deleteCustomer(@PathVariable("customerID") Long customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	@PutMapping(path = "{customerID}")
	public void updateCustomer(@PathVariable("customerID") Long customerId,
								@RequestBody Customer customer) {
		customerService.updateCustomer(customerId, customer);
	}

}

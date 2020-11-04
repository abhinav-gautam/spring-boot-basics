package com.abhinavgautam.springboot.springdatajpacrud.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinavgautam.springboot.springdatajpacrud.entity.Customer;
import com.abhinavgautam.springboot.springdatajpacrud.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomer(){
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer customer = customerService.findById(customerId);
		if(customer == null) {
			throw new RuntimeException("Customer not found");
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		Customer customer = customerService.findById(customerId);
		if(customer == null) {
			throw new RuntimeException("Customer not found");
		}
		customerService.delete(customerId);
	}
}

package com.abhinavgautam.springboot.springdatajpacrud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhinavgautam.springboot.springdatajpacrud.dao.CustomerRepository;
import com.abhinavgautam.springboot.springdatajpacrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer customer;
		if(customerOptional.get() == null) {
			throw new RuntimeException("Customer not found - "+id);
		}else {
			customer = customerOptional.get();
		}
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
	
}

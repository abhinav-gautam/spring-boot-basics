package com.abhinavgautam.thymeleafcustomercrud.service;

import java.util.List;

import com.abhinavgautam.thymeleafcustomercrud.entity.Customer;


public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer customer);

	public void delete(int id);
}

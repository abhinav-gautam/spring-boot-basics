package com.abhinavgautam.springboot.hibernatecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhinavgautam.springboot.hibernatecrud.dao.CustomerDAO;
import com.abhinavgautam.springboot.hibernatecrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		return customerDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDAO.delete(id);
	}
	
}

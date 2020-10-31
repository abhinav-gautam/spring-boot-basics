package com.abhinavgautam.springboot.hibernatecrud.dao;

import java.util.List;
import com.abhinavgautam.springboot.hibernatecrud.entity.Customer;

public interface CustomerDAO {
	public List<Customer> findAll();
	public Customer findById(int id);
	public void save(Customer customer);
	public void delete(int id);
}

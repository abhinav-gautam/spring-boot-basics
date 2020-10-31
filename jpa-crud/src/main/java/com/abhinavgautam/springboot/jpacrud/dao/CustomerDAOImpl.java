package com.abhinavgautam.springboot.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhinavgautam.springboot.jpacrud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Customer> findAll() {
		// Create a query
		Query query = entityManager.createQuery("from Customer");

		// Execute the query and get the result list
		List<Customer> customer = query.getResultList();

		// return the results
		return customer;
	}

	@Override
	public Customer findById(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Customer dbCustomer = entityManager.merge(customer);
		customer.setId(dbCustomer.getId());
	}

	@Override
	public void delete(int id) {
		Query query = entityManager.createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}

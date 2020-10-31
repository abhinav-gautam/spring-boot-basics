package com.abhinavgautam.springboot.hibernatecrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhinavgautam.springboot.hibernatecrud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Customer> findAll() {
		// Get current hibernate session
		Session session = entityManager.unwrap(Session.class);

		// Create a query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		// Execute the query and get the result list
		List<Customer> customer = query.getResultList();

		// return the results
		return customer;
	}

	@Override
	public Customer findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> query = session.createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}

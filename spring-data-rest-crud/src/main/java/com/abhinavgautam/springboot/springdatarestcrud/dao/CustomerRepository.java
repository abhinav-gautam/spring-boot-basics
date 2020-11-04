package com.abhinavgautam.springboot.springdatarestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinavgautam.springboot.springdatarestcrud.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

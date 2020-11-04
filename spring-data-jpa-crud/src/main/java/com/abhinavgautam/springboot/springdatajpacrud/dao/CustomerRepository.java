package com.abhinavgautam.springboot.springdatajpacrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinavgautam.springboot.springdatajpacrud.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

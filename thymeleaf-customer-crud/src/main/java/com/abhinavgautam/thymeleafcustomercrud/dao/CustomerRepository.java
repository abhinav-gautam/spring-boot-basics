package com.abhinavgautam.thymeleafcustomercrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinavgautam.thymeleafcustomercrud.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

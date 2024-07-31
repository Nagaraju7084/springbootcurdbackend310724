package com.curd.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByCustomerName(String customerName);
}

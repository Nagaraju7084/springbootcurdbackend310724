package com.curd.backend.service;

import java.util.List;

import com.curd.backend.dto.CustomerDto;

public interface CustomerService {
	String addCustomer(CustomerDto customerDto);
	List<CustomerDto> getAllCustomers();
	String updateCustomer(CustomerDto customerDto);
	boolean deleteCustomer(int id);
}

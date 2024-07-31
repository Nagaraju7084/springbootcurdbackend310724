package com.curd.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.backend.dto.CustomerDto;
import com.curd.backend.entity.Customer;
import com.curd.backend.repository.CustomerRepository;
import com.curd.backend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setCustomerAddress(customerDto.getCustomerAddress());
		customer.setCustomerMobile(customerDto.getCustomerMobile());
		customerRepository.save(customer);
		return customer.getCustomerName();
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> getCustomers = customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<>();
		for(Customer customer : getCustomers) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setCustomerAddress(customer.getCustomerAddress());
			customerDto.setCustomerMobile(customer.getCustomerMobile());
			customerDtoList.add(customerDto);
		}
		return customerDtoList;
	}

	@Override
	public String updateCustomer(CustomerDto customerDto) {
		Customer customer = customerRepository.findByCustomerName(customerDto.getCustomerName());
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setCustomerAddress(customerDto.getCustomerAddress());
		customer.setCustomerMobile(customerDto.getCustomerMobile());
		customerRepository.save(customer);

		return "customer updated...";
	}

	@Override
	public boolean deleteCustomer(int id) {
		if(customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
		}else {
			System.out.println("customer id not found...");
		}
		return true;
	}

}

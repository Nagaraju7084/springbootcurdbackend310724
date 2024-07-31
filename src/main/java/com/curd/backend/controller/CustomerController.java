package com.curd.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.backend.dto.CustomerDto;
import com.curd.backend.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public String saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.addCustomer(customerDto);
	}
	
	@GetMapping("/getAllCustomers")
	public List<CustomerDto> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@PutMapping("/update")
	public String updateCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(customerDto);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public String deleteCustomerById(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return "deleted";
	}
	
	

}

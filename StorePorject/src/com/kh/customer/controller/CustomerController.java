package com.kh.customer.controller;

import java.util.List;

import com.kh.customer.model.serivce.CustomerService;
import com.kh.customer.model.vo.Customer;

public class CustomerController {

	public int save(String customerId, String name, String email, String phone) {
		Customer customer = new Customer(customerId, name, email, phone);
		
		int result = new CustomerService().save(customer);
		
		return result;
	}

	public List<Customer> findAll() {
		List<Customer> customers = new CustomerService().findAll();
		
		
		
		return customers;
	}

}

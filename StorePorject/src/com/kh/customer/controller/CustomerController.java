package com.kh.customer.controller;

import java.util.List;

import com.kh.customer.model.dto.CustomerDTO;
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

	public List<Customer> findById(String customerId) {
		List<Customer> customers = new CustomerService().findById(customerId);
		return customers;
	}

	public Customer findByEmail(String email) {
		Customer customer = new CustomerService().findByEmail(email);
		return customer;
	}

	public List<Customer> findByName(String name) {
		List<Customer> customers = new CustomerService().findByName(name);
		return customers;
	}

	public int update(String name, String email, String newphoneNo) {
		CustomerDTO cdto = new CustomerDTO(name, email, newphoneNo);
		int result = new CustomerService().update(cdto);
		return result;
	}

	public int delete(String email) {
		int result = new CustomerService().delete(email);
		return result;
	}

}

package com.kh.customer.controller;

import com.kh.customer.model.serivce.CustomerService;
import com.kh.customer.model.vo.Customer;

public class CustomerController {

	public int save(String customerId, String name, String email, String phone) {
		Customer cutomer = new Customer(customerId, name, email, phone);
		
		int result = new CustomerService().save(cutomer);
		
		return result;
	}

}

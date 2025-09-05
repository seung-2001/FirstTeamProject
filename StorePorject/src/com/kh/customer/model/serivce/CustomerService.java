package com.kh.customer.model.serivce;

import java.sql.Connection;
import java.util.List;

import com.kh.customer.common.JDBCTemplate;
import com.kh.customer.model.dao.CustomerDao;
import com.kh.customer.model.dto.CustomerDTO;
import com.kh.customer.model.vo.Customer;

public class CustomerService {
	private Connection conn = null;
	
	public CustomerService() {
		super();
		this.conn = JDBCTemplate.getConnection();
	}

	public int save(Customer customer) {
		int result = new CustomerDao().save(conn, customer);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public List<Customer> findAll() {
		List<Customer> customers = new CustomerDao().findAll(conn);
		if(!customers.isEmpty()) {
			JDBCTemplate.close(conn);
		}
		return customers;
	}

	public List<Customer> findById(String customerId) {
		List<Customer> customers = new CustomerDao().findById(conn,customerId);
		
		if(!customers.isEmpty()) {
			JDBCTemplate.close(conn);
		}
		return customers;
	}

	public Customer findByEmail(String email) {
		Customer customer = new CustomerDao().findByEmail(conn,email);
		if(customer != null) {
			JDBCTemplate.close(conn);
		}
		return customer;
	}

	public List<Customer> findByName(String name) {
		List<Customer> customers = new CustomerDao().findByName(conn,name);
		
		if(!customers.isEmpty()) {
			JDBCTemplate.close(conn);
		}
		return customers;
	}

	public int update(CustomerDTO cdto) {
		int result = new CustomerDao().update(conn,cdto);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int delete(String email) {
		int result = new CustomerDao().delete(conn, email);
		if(result > 0) {
		}
		JDBCTemplate.close(conn);
		return result;
	}
}

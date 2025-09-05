package com.kh.customer.model.serivce;

import java.sql.Connection;

import com.kh.customer.common.JDBCTemplate;
import com.kh.customer.model.dao.CustomerDao;
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
}

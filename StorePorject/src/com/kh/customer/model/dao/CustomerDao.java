package com.kh.customer.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.customer.common.JDBCTemplate;
import com.kh.customer.model.vo.Customer;

public class CustomerDao {
	Properties prop  = new Properties();
	public CustomerDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/customer-mapper.xml"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int save(Connection conn, Customer customer) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql  = prop.getProperty("save");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getCustomerId());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Customer> findAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Customer> customers = new ArrayList();
		
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Customer customer = new Customer(rset.getString("CUSTOMER_ID")
											   , rset.getString("NAME")
											   , rset.getString("EMAIL")
											   , rset.getString("PHONE")
											   , rset.getDate("CREATED_AT"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return customers;
	}
}

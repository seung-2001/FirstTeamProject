package src.com.kh.customer.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import src.com.kh.customer.common.JDBCTemplate;
import src.com.kh.customer.model.dto.CustomerDTO;
import src.com.kh.customer.model.vo.Customer;

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

	public List<Customer> findById(Connection conn, String customerId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Customer> customers = new ArrayList();
		
		String sql = prop.getProperty("findById");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customerId);
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

	public Customer findByEmail(Connection conn, String email) {
		PreparedStatement pstmt = null;
		ResultSet rset =  null;
		Customer customer = new Customer();
		String sql = prop.getProperty("findByEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				customer = new Customer(rset.getString("CUSTOMER_ID")
						   , rset.getString("NAME")
						   , rset.getString("EMAIL")
						   , rset.getString("PHONE")
						   , rset.getDate("CREATED_AT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return customer;
	}

	public List<Customer> findByName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Customer> customers = new ArrayList();
		
		String sql = prop.getProperty("findByName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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

	public int update(Connection conn, CustomerDTO cdto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("update");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cdto.getNewphoneNo());
			pstmt.setString(2, cdto.getName());
			pstmt.setString(3, cdto.getEmail());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int delete(Connection conn, String email) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public Customer login(Connection conn, String email, String phone) {
	    PreparedStatement pstmt = null;
	    ResultSet rset = null;
	    Customer customer = new Customer();
	    String sql = prop.getProperty("login"); 

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, email);
	        pstmt.setString(2, phone);
	        rset = pstmt.executeQuery();
	        if (rset.next()) {
	            customer = new Customer(
	                rset.getString("CUSTOMER_ID"),
	                rset.getString("NAME"),
	                rset.getString("EMAIL"),
	                rset.getString("PHONE"),
	                rset.getDate("CREATED_AT")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCTemplate.close(rset);
	        JDBCTemplate.close(pstmt);
	    }
	    return customer;
	}
}

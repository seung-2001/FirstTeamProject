package com.kh.orders.model.DAO;

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
import com.kh.orders.model.DTO.OrdersDTO;
import com.kh.orders.model.vo.Orders;

public class OrdersDAO {

	private Properties prop = new Properties();
	
	public OrdersDAO() {
		try {
			prop.loadFromXML(new FileInputStream("resources/order-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int orderSave(Connection conn, Orders orders) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("orderSave");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orders.getCustomerId());
			pstmt.setInt(2, orders.getProductId());
			pstmt.setInt(3, orders.getQuantity());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Orders> orderFindAll(Connection conn) {
		
		List<Orders> orders = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderFindAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Orders order = new Orders(rset.getInt("ORDER_ID")
						, rset.getInt("CUSTOMER_ID")
						, rset.getInt("PRODUCT_ID")
						, rset.getInt("QUANTITY")
						, rset.getDate("ORDER_DATE"));
				
				orders.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return orders;
	}

	public int orderUpdate(Connection conn, OrdersDTO od) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("orderUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, od.getNewQuantity());
			pstmt.setInt(2, od.getCustomerId());
			pstmt.setInt(3, od.getQuantity());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int orderDelete(Connection conn, Orders orders) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("orderDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orders.getOrderId());
			pstmt.setInt(2, orders.getCustomerId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}

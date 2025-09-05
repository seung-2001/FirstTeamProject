package com.kh.orders.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.customer.common.JDBCTemplate;
import com.kh.orders.model.DAO.OrdersDAO;
import com.kh.orders.model.DTO.OrdersDTO;
import com.kh.orders.model.vo.Orders;

public class OrdersService {
	
	private Connection conn = null;

	public OrdersService() {
		super();
		this.conn = JDBCTemplate.getConnection();
	}

	public int orderSave(Orders orders) {
		
		int result = new OrdersDAO().orderSave(conn, orders);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<Orders> orderFindAll() {
		
		List<Orders> orders = new OrdersDAO().orderFindAll(conn);
		
		JDBCTemplate.close(conn);
		
		return orders;
	}

	public int orderUpdate(OrdersDTO od) {
		
		int result = new OrdersDAO().orderUpdate(conn, od);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int orderDelete(Orders orders) {
		
		int result = new OrdersDAO().orderDelete(conn, orders);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}

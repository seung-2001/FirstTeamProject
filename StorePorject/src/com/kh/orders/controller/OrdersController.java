package src.com.kh.orders.controller;

import java.util.List;

import src.com.kh.orders.model.DTO.OrdersDTO;
import src.com.kh.orders.model.service.OrdersService;
import src.com.kh.orders.model.vo.Orders;

public class OrdersController {

	public int orderSave(String customerId, int productId, int quantity) {
	
		Orders orders = new Orders(customerId, productId, quantity);
		
		int result = new OrdersService().orderSave(orders);
		
		return result;
	}

	public List<Orders> orderFindAll() {
		
		List<Orders> orders = new OrdersService().orderFindAll();
		
		return orders;
	}

	public int oderUpdate(int customerId, int quantity, int newQuantity) {
		
		OrdersDTO od = new OrdersDTO(customerId, quantity, newQuantity);
		
		int result = new OrdersService().orderUpdate(od);
		
		return result;
	}

	public int orderDelete(int orderId, String customerId) {
		
		Orders orders = new Orders(orderId, customerId);
		int result = new OrdersService().orderDelete(orders);
		
		return result;
	}

}

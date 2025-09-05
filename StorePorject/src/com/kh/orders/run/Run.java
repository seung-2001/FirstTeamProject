package com.kh.orders.run;

import com.kh.customer.common.JDBCTemplate;
import com.kh.orders.view.OrdersView;

public class Run {

	public static void main(String[] args) {

		JDBCTemplate.registerDriver();
		
		OrdersView or = new OrdersView();
		or.mainMenu();
	}

}

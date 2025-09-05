package src.com.kh.orders.run;

import src.com.kh.customer.common.JDBCTemplate;
import src.com.kh.orders.view.OrdersView;

public class Run {

	public static void main(String[] args) {

		JDBCTemplate.registerDriver();
		
		OrdersView or = new OrdersView();
		or.mainMenu();
	}

}

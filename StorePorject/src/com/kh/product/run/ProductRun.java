package src.com.kh.product.run;

import src.com.kh.product.common.JDBCTemplate;
import src.com.kh.product.view.ProductView;

public class ProductRun {

	public static void main(String[] args) {
		
		JDBCTemplate.registerDriver();
		ProductView pv = new ProductView();
		pv.mainMenu();

		
	}

}

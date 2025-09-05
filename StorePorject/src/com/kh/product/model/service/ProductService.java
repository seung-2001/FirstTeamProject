package src.com.kh.product.model.service;

import static src.com.kh.customer.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import src.com.kh.product.model.dao.ProductDao;
import src.com.kh.product.model.dto.ProductDto;
import src.com.kh.product.model.vo.Product;

public class ProductService {

	private Connection conn = null;
	
	public ProductService() {
		this.conn = getConnection();
	}
	
	
	public List<Product> findAll() {

		List<Product> products = new ProductDao().findAll(conn);
		
		close(conn);
		
		return products;
	}


	public Product findByName(String name) {

		Product product = new ProductDao().findByName(conn, name);
		
		close(conn);
		
		return product;
	}


	public int save(Product product) {

		int result = new ProductDao().save(conn, product);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updatePrice(ProductDto pd) {

		int result = new ProductDao().updatePrice(conn, pd);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int updateStock(ProductDto pd) {

		int result = new ProductDao().updatePrice(conn, pd);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}

	public int delete(Product product) {

		int result = new ProductDao().delete(conn, product);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}



}

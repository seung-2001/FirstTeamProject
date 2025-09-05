package src.com.kh.product.controller;

import java.util.List;

import src.com.kh.product.model.dto.ProductDto;
import src.com.kh.product.model.service.ProductService;
import src.com.kh.product.model.vo.Product;

public class ProductController {

	public List<Product> findAll() {

		List<Product> products = new ProductService().findAll();
		
		return products;
	}

	public Product findByName(String name) {
		
		Product product = new ProductService().findByName(name);
		
		return product;
	}

	public int save(int productId, String name, String category, int price, int stock) {

		Product product = new Product(productId, name, category, price, stock);
		
		int result = new ProductService().save(product);
		
		return result;
	}

	public int updatePrice(int productId, String name, int newPrice) {

		ProductDto pd = new ProductDto();
		pd.setProductId(productId);
		pd.setName(name);
		pd.setNewPrice(newPrice);
		
		int result = new ProductService().updatePrice(pd);
		
		return result;
	}
	
	public int updateStock(int productId, String name, int newStock) {

		ProductDto pd = new ProductDto();
		pd.setProductId(productId);
		pd.setName(name);
		pd.setNewStock(newStock);
		
		int result = new ProductService().updateStock(pd);
		
		return result;
	}
	
	public int delete(int productId, String name) {

		Product product = new Product();
		product.setProductId(productId);
		product.setName(name);
		
		int result = new ProductService().delete(product);
		
		return result;
	}


}

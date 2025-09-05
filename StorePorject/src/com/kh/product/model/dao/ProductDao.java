package src.com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import src.com.kh.product.common.JDBCTemplate;
import src.com.kh.product.model.dto.ProductDto;
import src.com.kh.product.model.vo.Product;

public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/product-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Product> findAll(Connection conn) {

		List<Product> products = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product(rset.getInt("PRODUCT_ID")
						                     ,rset.getString("NAME")
						                     ,rset.getString("CATEGORY")
						                     ,rset.getInt("PRICE")
						                     ,rset.getInt("STOCK"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return products;
	}

	public Product findByName(Connection conn, String name) {

		Product product = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				product = new Product(rset.getInt("PRODUCT_ID")
						             ,rset.getString("NAME")
						             ,rset.getString("CATEGORY")
						             ,rset.getInt("PRICE")
						             ,rset.getInt("STOCK"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return product;
	}

	public int save(Connection conn, Product product) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("save");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getCategory());
			pstmt.setInt(4, product.getPrice());
			pstmt.setInt(5, product.getStock());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updatePrice(Connection conn, ProductDto pd) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pd.getNewPrice());
			pstmt.setInt(2, pd.getProductId());
			pstmt.setString(3, pd.getName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateStock(Connection conn, ProductDto pd) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateStock");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pd.getNewStock());
			pstmt.setInt(2, pd.getProductId());
			pstmt.setString(3, pd.getName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	public int delete(Connection conn, Product product) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("delete");
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


}

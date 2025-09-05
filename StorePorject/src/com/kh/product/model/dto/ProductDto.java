package src.com.kh.product.model.dto;

public class ProductDto {
	
	private int productId;
	private String name;
	private int newPrice;
	private int newStock;
	
	public ProductDto() {
		super();
	}
	public ProductDto(int productId, String name, int newPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.newPrice = newPrice;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}
	public int getNewStock() {
		return newStock;
	}
	public void setNewStock(int newStock) {
		this.newStock = newStock;
	}
	
	
	
	

}

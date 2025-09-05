package src.com.kh.product.model.vo;

import java.util.Objects;

public class Product {

	private int productId;
	private String name;
	private String category;
	private int price;
	private int stock;

	public Product() {
		super();
	}

	public Product(int productId, String name, String category, int price, int stock) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, name, price, productId, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(name, other.name) && price == other.price
				&& productId == other.productId && stock == other.stock;
	}
	
	
	

}

package src.com.kh.orders.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Orders {

	private int orderId;
	private int customerId;
	private int productId;
	private int quantity;
	private Date orderDate;

	public Orders() {
		super();
	}

	public Orders(int orderId, int customerId, int productId, int quantity, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}
	
	

	public Orders(int orderId, int customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}

	public Orders(int customerId, int productId, int quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, orderDate, orderId, productId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return customerId == other.customerId && Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
				&& productId == other.productId && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", orderDate=" + orderDate + "]";
	}

	

}

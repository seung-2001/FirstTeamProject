package src.com.kh.orders.model.DTO;

public class OrdersDTO {

	private int customerId;
	private int quantity;
	private int newQuantity;

	public OrdersDTO() {
		super();
	}

	public OrdersDTO(int customerId, int quantity, int newQuantity) {
		super();
		this.customerId = customerId;
		this.quantity = quantity;
		this.newQuantity = newQuantity;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}

	public int getNewQuantity() {
		return newQuantity;
	}

}

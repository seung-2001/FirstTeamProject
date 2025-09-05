package src.com.kh.customer.model.vo;

import java.sql.Date;

public class Customer {
	private String customerId;
	private String name;
	private String email;
	private String phone;
	private Date createDate;
	
	public Customer() {
		super();
	}
	
	
	
	public Customer(String customerId, String name, String email, String phone) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}



	public Customer(String customerId, String name, String email, String phone, Date createDate) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.createDate = createDate;
	}


	public String getCustomerId() {
		return customerId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	
	

}

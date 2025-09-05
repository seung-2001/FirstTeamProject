package src.com.kh.customer.model.dto;

import java.util.Objects;

public class CustomerDTO {
	private String name;
	private String email;
	private String newphoneNo;
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(String name, String email, String newphoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.newphoneNo = newphoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewphoneNo() {
		return newphoneNo;
	}
	public void setNewphoneNo(String newphoneNo) {
		this.newphoneNo = newphoneNo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, name, newphoneNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(newphoneNo, other.newphoneNo);
	}
	
	
	/*
	 * String name, String email, String newphoneNo
	 */
}

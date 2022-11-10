package model;

public class Customer {
	private String cus_id, cus_name, cus_phone, cus_mail, cus_address;
	private int cus_age;
	
	public Customer(String cus_id, String cus_name, String cus_phone, String cus_mail, String cus_address,
			int cus_age) {
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_phone = cus_phone;
		this.cus_mail = cus_mail;
		this.cus_address = cus_address;
		this.cus_age = cus_age;
	}

	public Customer() {
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_phone() {
		return cus_phone;
	}

	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}

	public String getCus_mail() {
		return cus_mail;
	}

	public void setCus_mail(String cus_mail) {
		this.cus_mail = cus_mail;
	}

	public String getCus_address() {
		return cus_address;
	}

	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}

	public int getCus_age() {
		return cus_age;
	}

	public void setCus_age(int cus_age) {
		this.cus_age = cus_age;
	}
	
	
	
}

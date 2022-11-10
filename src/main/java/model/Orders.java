package model;

public class Orders {
	private String order_id, order_status, order_date, order_discount_code, order_address, cus_id;
	
	public Orders() {
	}

	public Orders(String order_id, String order_status, String order_date, String order_discount_code,
			String order_address, String cus_id) {
		this.order_id = order_id;
		this.order_status = order_status;
		this.order_date = order_date;
		this.order_discount_code = order_discount_code;
		this.order_address = order_address;
		this.cus_id = cus_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_discount_code() {
		return order_discount_code;
	}

	public void setOrder_discount_code(String order_discount_code) {
		this.order_discount_code = order_discount_code;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	
	
	
}

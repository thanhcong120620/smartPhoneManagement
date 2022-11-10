package model;

public class cart {
	private String cus_name;
	private String cus_phone;
	private String product_name;
	private double product_price;
	private int quantity;
	private double amount_product;
	private double total;
	
	public cart() {
	}

	public cart(String cus_name, String cus_phone, String product_name, double product_price, int quantity,
			double amount_product, double total) {
		super();
		this.cus_name = cus_name;
		this.cus_phone = cus_phone;
		this.product_name = product_name;
		this.product_price = product_price;
		this.quantity = quantity;
		this.amount_product = amount_product;
		this.total = total;
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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount_product() {
		return amount_product;
	}

	public void setAmount_product(double amount_product) {
		this.amount_product = amount_product;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "cart [cus_name=" + cus_name + ", cus_phone=" + cus_phone + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", quantity=" + quantity + ", amount_product=" + amount_product
				+ ", total=" + total + "]";
	}


	
	
	
	
}

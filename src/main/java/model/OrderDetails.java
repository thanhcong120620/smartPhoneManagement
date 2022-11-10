package model;

import java.util.ArrayList;

public class OrderDetails {
	private String order_id, product_id;
	private Double amount_product;
	private Double product_price;
	private ArrayList<OrderDetails> listOrderDetailMD = null;
	
	public OrderDetails() {
	}

	public OrderDetails(String order_id, String product_id, Double amount_product, Double product_price) {
		this.order_id = order_id;
		this.product_id = product_id;
		this.amount_product = amount_product;
		this.product_price = product_price;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Double getAmount_product() {
		return amount_product;
	}

	public void setAmount_product(Double amount_product) {
		this.amount_product = amount_product;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	
	public void addListOrderDetailsMD(OrderDetails orderDetails) {
		this.listOrderDetailMD.add(orderDetails);
	}

	

	public ArrayList<OrderDetails> getListOrderDetailMD() {
		return listOrderDetailMD;
	}

	public void setListOrderDetailMD(ArrayList<OrderDetails> listOrderDetailMD) {
		this.listOrderDetailMD = listOrderDetailMD;
	}

	@Override
	public String toString() {
		return "OrderDetails [order_id=" + order_id + ", product_id=" + product_id + ", amount_product="
				+ amount_product + ", product_price=" + product_price + "]";
	}
	
	
	
}

package model;

import java.util.ArrayList;

public class Products {
	private String product_id, product_name, product_img_source, product_type, product_brand;
	private double product_price;
	public ArrayList<Products> listProductsMD = null;
	
	public Products() {
		
	}


	

	public Products(String product_id, String product_name, String product_img_source, String product_type,
			String product_brand, double product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_img_source = product_img_source;
		this.product_type = product_type;
		this.product_brand = product_brand;
		this.product_price = product_price;
	}




	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_img_source() {
		return product_img_source;
	}

	public void setProduct_img_source(String product_img_source) {
		this.product_img_source = product_img_source;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	


	public ArrayList<Products> getListProductsMD() {
		return listProductsMD;
	}

	public void setListProductsMD(ArrayList<Products> listProductsMD) {
		this.listProductsMD = listProductsMD;
	}

	public void addListProductsMD(Products products) {
		this.listProductsMD.add(products);
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_img_source="
				+ product_img_source + ", product_type=" + product_type + ", product_brand=" + product_brand
				+ ", product_price=" + product_price + "]";
	}
	
	
	
}

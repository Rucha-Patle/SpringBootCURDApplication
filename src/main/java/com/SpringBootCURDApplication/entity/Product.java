package com.SpringBootCURDApplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	private int  productId; 
	private float version;
	private String name; 
	private double price;
	
	@Id
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getVersion() {
		return version;
	}
	public void setVersion(float version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product(int productId, float version, String name, double price) {
		super();
		this.productId = productId;
		this.version = version;
		this.name = name;
		this.price = price;
	}
	
	public Product() {
		super();
	}
	
}

package com.model;

public class Product {
	private String id;
	private String Name;
	private String Quantity;
	private String QuentityAded;
	private String Mrp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getQuentityAded() {
		return QuentityAded;
	}
	public void setQuentityAded(String quentityAded) {
		QuentityAded = quentityAded;
	}
	public String getMrp() {
		return Mrp;
	}
	public void setMrp(String mrp) {
		Mrp = mrp;
	}
	@Override
	public String toString() {
		return "Product id=" + id + ", Name=" + Name + ", Quantity=" + Quantity + ", QuentityAded=" + QuentityAded
				+ ", Mrp=" + Mrp + "";
	}
	
	
}

package com.model;

public class Bill {
	private String billno;
	private String customername;
	private String productId;
	private String name;
	private String mrp;
	private String quantiy;
	private String discount;
	private String date;
	private String total;
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public String getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(String quantiy) {
		this.quantiy = quantiy;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Bill billno=" + billno + ", customerId=" + customername + ", productId=" + productId + ", name=" + name
				+ ", mrp=" + mrp + ", quantiy=" + quantiy + ", discount=" + discount + ", date=" + date + ", total="
				+ total + "";
	}
	

}

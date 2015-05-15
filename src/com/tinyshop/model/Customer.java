package com.tinyshop.model;

public class Customer {

	private String customerID;
	private String customerName;
	private String Address;
	private String Type;
	private int points;
	private double discountOnBill;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public double getDiscountOnBill() {
		return discountOnBill;
	}

	public void setDiscountOnBill(double discountOnBill) {
		this.discountOnBill = discountOnBill;
	}

}

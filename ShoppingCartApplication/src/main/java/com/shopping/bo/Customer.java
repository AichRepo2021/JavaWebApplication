package com.shopping.bo;

public class Customer extends User{
	private double amount;
	private String productName;

	/*
	 * public Customer(double amount,String productName) { this.amount=amount;
	 * this.productName=productName;
	 * 
	 * }
	 */
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}

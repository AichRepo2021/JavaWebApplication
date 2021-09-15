package com.shopping.bo;

public class User {
	private int id;
	private String name;
	private String userType;
	private String resisterDate;
	private double billAmount;
	
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public String getResisterDate() {
		return resisterDate;
	}
	public void setResisterDate(String resisterDate) {
		this.resisterDate = resisterDate;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}

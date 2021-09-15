package com.shopping.service;

import com.shopping.bo.User;

public interface Discount {
	public double getDiscount(Double amt, String productType, String userType);
	//public double billamount(String UserType,double amount,String productName);
	public User userType(User user);

}

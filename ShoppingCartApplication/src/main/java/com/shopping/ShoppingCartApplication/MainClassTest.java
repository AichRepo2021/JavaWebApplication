package com.shopping.ShoppingCartApplication;

import com.shopping.bo.Customer;
import com.shopping.bo.Employee;
import com.shopping.bo.User;
import com.shopping.serviceImpl.DiscountFactory;

public class MainClassTest {
	
	public static void main(String[] args) {
		DiscountFactory discountFactory=new DiscountFactory();
		Customer e=new Customer();
		e.setAmount(100.00);
		e.setProductName("Electronics");
		e.setUserType("Customer");
		User u=  discountFactory.userType(e);
		System.out.println(u.getBillAmount());
	}

}

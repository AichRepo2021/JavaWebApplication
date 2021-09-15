package com.shopping.ShoppingCartApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.shopping.bo.Customer;
import com.shopping.bo.Employee;
import com.shopping.bo.User;
import com.shopping.serviceImpl.DiscountFactory;

public class MainClassTest {

	public static void main(String[] args) {
		SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String mdy = obj.format(date);
		
		DiscountFactory discountFactory = new DiscountFactory();
		Customer e = new Customer();
		e.setBillAmount(1000.00);
		
		e.setProductType("Electronics");
		e.setPurchaseDate(mdy);
		User u = discountFactory.userType(e);
		System.out.println(u.getBillAmount());
	}

}

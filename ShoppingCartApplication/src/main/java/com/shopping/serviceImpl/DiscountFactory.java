package com.shopping.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.shopping.bo.Affiliate;
import com.shopping.bo.Customer;
import com.shopping.bo.Employee;
import com.shopping.bo.User;
import com.shopping.service.UserType;

public class DiscountFactory implements UserType {
	SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	@Override
	public User userType(User user) {

		if (user instanceof Employee) {
			//Employee e = new Employee();
			user.setUserType("Employee");
			double billAmount = getDiscountCalculate(user);
			user.setBillAmount(billAmount);
			return user;
		} else if (user instanceof Customer) {
			//Customer e = new Customer();
			user.setUserType("Customer");
			double billAmount = getDiscountCalculate(user);
			user.setBillAmount(billAmount);
			return user;
		} else if (user instanceof Affiliate) {
			//Affiliate e = new Affiliate();
			user.setUserType("Affiliate");
			double billAmount = getDiscountCalculate(user);
			user.setBillAmount(billAmount);

			return user;
		}
		return user;

	}

	
	private  double getDiscountCalculate(User user) {
		
		double billamount=user.getBillAmount();
		String PurchaseDate=user.getPurchaseDate();
		String userType=user.getUserType();
		String productType=user.getProductType();
		
		
		if (userType.equalsIgnoreCase("Employee")) {
			if (!productType.equals("groceries")) {

				double quotient = (billamount * 30) / 100;
				billamount = billamount - quotient;
				System.out.println("Total Bill::" + user.getBillAmount());
				System.out.println("Employee 30%  Discount Apply" + quotient);
				System.out.println("After discount::" + billamount);
			} else {
				if (billamount > 100) {
					billamount = extracted(billamount);
					
				}
			}

		} else if (userType.equalsIgnoreCase("Customer")) {
			
			try {	
			Date todayDate= obj.parse(PurchaseDate);
			if (!productType.equals("groceries")) {

				Date date1 = obj.parse("12-12-2017 02:11:20");
				// Date date2 = obj.parse("1-26-2020 07:15:50");
				long time_difference = todayDate.getTime() - date1.getTime();
				
		         long difference_In_Years= (time_difference
	                   / (1000l * 60 * 60 * 24 * 365));
				if (difference_In_Years > 2) {
					double quotient = (billamount * 5) / 100;
					billamount = billamount - quotient;
					System.out.println("Total Bill::" + billamount);
					System.out.println("Customer 5 %  Discount Apply" + quotient);
					System.out.println("After discount::" + billamount);
				}
				billamount = extracted(billamount);
			} else {
				billamount = extracted(billamount);
			}		
			
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (userType.equalsIgnoreCase("Affiliate")) {
		
			if (!productType.equals("groceries")) {
				double quotient = (billamount * 10) / 100;
				billamount = billamount - quotient;
				System.out.println("Total Bill::" + billamount);
				System.out.println("Affiliate 10 %  Discount Apply" + quotient);
				System.out.println("After discount::" + billamount);

			} else {

				billamount = extracted(billamount);
			}

		}else {
			return billamount;
		}
			
			
		return billamount;
		
	}
	
	private double extracted(double amount) {
		double quotient = amount / 100;

		amount = amount - (quotient * 5);
		return amount;
	}
}

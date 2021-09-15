package com.shopping.serviceImpl;

import com.shopping.bo.Affiliate;
import com.shopping.bo.Customer;
import com.shopping.bo.Employee;
import com.shopping.bo.User;
import com.shopping.service.Discount;

public class DiscountFactory implements Discount {

	@Override
	public User userType(User user) {

		if (user instanceof Employee) {
			Employee e = new Employee();
			double billAmount = getDiscount(((Employee) user).getAmount(), ((Employee) user).getProductName(),
					user.getUserType());
			e.setBillAmount(billAmount);
			return e;
		} else if (user instanceof Customer) {

			Customer e = new Customer();
			double billAmount = getDiscount(((Customer) user).getAmount(), ((Customer) user).getProductName(),
					user.getUserType());
			e.setBillAmount(billAmount);
			return e;

		} else if (user instanceof Affiliate) {
			Affiliate e = new Affiliate();
			double billAmount = getDiscount(((Affiliate) user).getAmount(), ((Affiliate) user).getProductName(),
					user.getUserType());
			e.setBillAmount(billAmount);

			return e;
		}
		return user;

	}

	@Override
	public double getDiscount(Double amt, String productType, String userType) {
		// TODO Auto-generated method stub

		if (userType.equalsIgnoreCase("Employee")) {
			return 500.00;
		} else if (userType.equalsIgnoreCase("Customer")) {
			return 1200;
		} else if (userType.equalsIgnoreCase("Affiliate")) {
			return 1300;
		} else {
			return amt;
		}
	}

}

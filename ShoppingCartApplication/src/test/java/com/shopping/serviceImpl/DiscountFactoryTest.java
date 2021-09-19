package com.shopping.serviceImpl;




import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.shopping.bo.Affiliate;
import com.shopping.bo.Customer;
import com.shopping.bo.Employee;
import com.shopping.bo.User;

public class DiscountFactoryTest {
	DiscountFactory discountFactory = new DiscountFactory();
	
	@Test
	public void testBillamountCutomer_before_2years_5_percent_discount() {
		SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String mdy = obj.format(date);
		Customer e = new Customer();
		e.setBillAmount(1000.00);
		e.setUserType("Customer");
		e.setProductType("Electronics");
		e.setPurchaseDate(mdy);
		User u = discountFactory.userType(e);
		double actual=u.getBillAmount();
		//assertEquals(600, expectedAmt);
		
		assertEquals(902.50, actual);
		//assertEquals(700.00,actual);
		
	}
	
	@Test
	public void testBillamountEmployee_30_percent_discount() {
		SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String mdy = obj.format(date);
		
		
		Employee e = new Employee();
		e.setBillAmount(1000.00);
		e.setProductType("Electronics");
		e.setPurchaseDate(mdy);
		User u = discountFactory.userType(e);
		double actual=u.getBillAmount();
		//assertEquals(600, expectedAmt);
		
		//assertEquals(600.00, actual);
		assertEquals(700.00,actual);
		
	}
	
	@Test
	public void testBillamountCutomer_not_before_2_year_percent_tDiscount() {
		
		Customer e = new Customer();
		e.setBillAmount(1000.00);
		e.setProductType("Electronics");
		e.setPurchaseDate("12-12-2017 02:11:20");
		User u = discountFactory.userType(e);
		double actual=u.getBillAmount();
		//assertEquals(600, expectedAmt);
		
		assertEquals(950.00, actual);
		//assertEquals(900.00,actual);
		
	}
	

	@Test
	public void testBillamountAffiliate_10_percent_tDiscount() {
		SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String mdy = obj.format(date);
		
		
		Affiliate e = new Affiliate();
		e.setBillAmount(1000.00);
		e.setProductType("Electronics");
		e.setPurchaseDate(mdy);
		User u = discountFactory.userType(e);
		double actual=u.getBillAmount();
		
		
		assertEquals(900.00, actual);
		//assertEquals(700.00,actual);
		
	}
	
	@Test
	public void testBillamountAffiliate_checkNull_object() {
		SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String mdy = obj.format(date);
		
		
		Affiliate e = null;
		e.setBillAmount(1000.00);
		e.setProductType("Electronics");
		e.setPurchaseDate(mdy);
		User u = discountFactory.userType(e);
		//double actual=u.getBillAmount();
		assertNull(mdy,e);  
		
		//assertEquals(700.00,actual);
		
	}
	

}

package com.tinyshop.billgenerator;

import com.tinyshop.model.Customer;

public class Test22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	StringBuilder builder = new StringBuilder();
		builder.getProductsListWithPrice("ads", "dsadsa",12, 23.00);
		builder.getProductsListWithPrice("fff", "4r4r",12, 23.00);
		String s = builder.getProductsListWithPrice("nnn", "zzz",12, 23.00);
		System.out.println(s);*/
		
		Customer customer = new Customer();
		customer.setCustomerID("CUS12345");
		customer.setCustomerName("Amila");
		customer.setPoints(12);
		customer.setType("Silver");
		customer.setAddress("CMB");
		customer.setDiscountOnBill(3);
		
		String s="{ \"GA001\", \"A\", \"x\", \"50.00\" }, { \"GA001\", \"A\", \"x\", \"50.00\" }";

		String billNo="BL - 915 - 05";
		String date="23/ 04/ 2015";
		PDFGenerator generator = new PDFGenerator(customer,100.00, billNo , date);

	}

}

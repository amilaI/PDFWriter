package com.tinyshop.billgenerator;

public class StringBuilder {
	
	private static String productListString;
	
	public StringBuilder() {
		productListString = "";
	}

	
	
	public String getProductsListWithPrice(String itemNo , String type , int units , double price) {
//		/{ "GA001", "A" ,"x" , "50.00"}
		
		String product = "{"+itemNo + ","+type+ ","+units+ ","+price+"}";	
		productListString=productListString.concat(product + " , ");
		return productListString;
	}
}

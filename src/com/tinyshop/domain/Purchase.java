package com.tinyshop.domain;

public class Purchase extends Customer{

 double Amount;
 double Discount=0.0;
 float points;
 double Bill=0.0;


public Purchase(){
	super();
	Amount=0;
}

public Purchase(Customer obj,double amount){
	super(obj);
	this.Amount=amount;
}

public Purchase(double Amount){
	this.Amount=Amount;
}

public Purchase(String customerID,String customerName,String Address,double Amount){
	super(customerID,customerName,Address);
	this.Amount=Amount;
}



public float runPurchase(Customer no){
	char x= no.type;
	if (x=='G') {
		return points=3.0f;
	}
		else if(x=='S'){
			return points=2.0f;
				}
			else if(x=='B'){
				return points=1.0f;
			}
		
			 else{
			 	
			 	return points=0.0f;
			 }
}

public double getDiscount(String product){

	if ((Amount<=5000 && product.equals("A")) 
		||(Amount>5000 && Amount <=10000 && product.equals("A") ) ){
		return Discount=0.05;
	}

		else if((Amount<=5000 && product.equals("B")) 
		||(Amount>5000 && Amount <=10000 && product.equals("C") )||
		(Amount>10000 && product.equals("A"))){
			return Discount=0.04;

		}

			else if( (Amount<=5000 && product.equals("C")) 
		||(Amount>5000 && Amount <=10000 && product.equals("B") )||
		(Amount>10000 && product.equals("B"))
		||(Amount>10000 && product.equals("C"))){
			return Discount=0.06;
		}
			else{

				System.out.println("Wrong input");
				//return Discount=0;
			}

		return Discount=0;
}

		public double prepareBill(String BillID){
			 Bill=Amount - (Amount*Discount);

			System.out.println("The Bill ID : "+BillID);
			 return Bill;
		}

		public void showBill(){
			double DiscountAmount=Amount*Discount;
			System.out.println("Gross Total : "+Amount);
			System.out.println("The Discount  : "+DiscountAmount);
			System.out.println("The  Bill netTotal  : "+Bill);
			System.out.println("===============================\nThanks for being with us you have earned "+ points +"in this purchase");




		}

}
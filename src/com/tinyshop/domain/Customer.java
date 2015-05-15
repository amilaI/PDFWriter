package com.tinyshop.domain;

import java.util.Scanner;

public class Customer{

String customerID;
String customerName;
String Address;
char type;


public Customer(Customer obj){
customerID=obj.customerID;
customerName=obj.customerName;
Address=obj.Address;

}

public Customer(String customerID,String customerName,String Address){
this.customerID=customerID;
this.customerName=customerName;
this.Address=Address;
}

public Customer(){
	customerID="Not set";
	customerName="Not set";
	Address="Not set";
}

public void askType(char type){
	
	this.type=type;

}

public char getType(){
return type;

}
public void askCus (){
String $customerID,$customerName,$Address;
Scanner input= new Scanner (System.in);
System.out.print("Enter the customer ID: ");
$customerID=input.nextLine();
customerID=$customerID;
System.out.print("Enter the customer Name: ");
$customerName=input.nextLine();
customerName=$customerName;
System.out.print("Enter the customer Address: ");
$Address=input.nextLine();
Address=$Address;

}

public void display (){

System.out.println("\n\n *********Bill*********");

System.out.println("Customer ID:\t"+customerID);
System.out.println("Customer name:\t"+customerName);
System.out.println("Address:\t"+Address);
System.out.println("Customer Type:\t"+type);


}



}

package com.tinyshop.domain;

import java.util.Scanner;

public class Main extends Purchase{

public static void main(String[] args) {

Customer customer=new  Customer();
customer.askCus();

Scanner input2= new Scanner (System.in);
System.out.print("Enter customer Type: ");
char myType=input2.next().charAt(0);

customer.askType(myType);



Scanner reader=new Scanner(System.in);
System.out.print("Enter product type : ");
String $product= reader.nextLine();

System.out.print("Enter the Bill Amount : ");
double $amount= reader.nextDouble();
Purchase pus=new Purchase(customer,$amount);
pus.getDiscount($product);
pus.prepareBill("B0001");
pus.runPurchase(customer);



customer.display();
pus.showBill();


}

}
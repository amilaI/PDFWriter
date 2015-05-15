package com.tinyshop.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public DatabaseConnection() {
		initializer();
	}
	
	
	public void initializer() {
		 Connection con = null;
	        PreparedStatement pst = null;

	        String url = "jdbc:mysql://localhost:3306/testdb";
	        String user = "testuser";
	        String password = "test623";

	        try {

	            String author = "Trygve Gulbranssen";
	            con = DriverManager.getConnection(url, user, password);

	            pst = con.prepareStatement("INSERT INTO CustomerBill(BillId, CustomerId, Date, ProductItemList) VALUES(1, 1, 'Call of the Wild',1);");
	            pst.setString(1, author);
	            pst.executeUpdate();

	        } catch (SQLException ex) {
	            System.out.println(ex);

	        } finally {

	            try {
	                if (pst != null) {
	                    pst.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	            	 System.out.println(ex);
	            }
	        }
	}

}

package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UnitInformation {
	// connect to the db
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid","root","sajana1999");
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Error connected");
		}
		return con;
	}
	
	


}

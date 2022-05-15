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
	//insert Units details
	public String insertUnits(String date, String validMonth, String unitRange, String unitprice) {
		String output = "";
		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into units(`date`,`validMonth`,`unitRange`,`unitPrice`)"
					+ " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
						
			preparedStmt.setString(1, date);
			preparedStmt.setString(2, validMonth);
			preparedStmt.setString(3, unitRange);
			preparedStmt.setString(4, unitprice);
			

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Units details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	public String readUnits() {
		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\" class=\"table\"> <tr>"
					+ "<th>Date</th> "
					+ "<th>Valid Month</th>"
			 		+ "<th>Unit Range</th>"
			 		+ "<th>Unit Price</th>"
			 		+ "<th>Update</th>  <th>Remove</th></tr>";

			String query = "select * from units";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String unitsId = Integer.toString(rs.getInt("unitsId"));
				String date = rs.getString("date");
				String validMonth = rs.getString("validMonth");
				String unitRange = rs.getString("unitRange");
				String unitPrice = Integer.toString(rs.getInt("unitPrice"));
				
				

				// Add into the html table
				
				
				output += "<tr><td><input id='hideUnitInformationIDUpdate' name='hideUnitInformationIDUpdate' type='hidden' value='"+unitsId+"'>"+date+"</td>";
				output += "<td>" + validMonth + "</td>";
				output += "<td>" + unitRange + "</td>";
				output += "<td>" + unitPrice + "</td>";


				// buttons
				output +=  "<td><input name='btnUpdate' type='button' value='Update' "
						 + "class='btnUpdate btn btn-secondary' data-usageid='" + unitsId + "'></td>"
						 + "<td><input name='btnRemove' type='button' value='Remove' "
						 + "class='btnRemove btn btn-danger' data-usageid='" + unitsId + "'></td></tr>"; 
			}
			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the inquiries.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	public String updateUnits(String ID, String date, String validMonth, String unitRange, String unitprice) {
		String output = "";
		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE units SET date = ? , validMonth = ? , unitRange = ? , unitPrice = ? WHERE unitsId=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
									
			preparedStmt.setString(1, date);
			preparedStmt.setString(2, validMonth);
			preparedStmt.setString(3, unitRange);
			preparedStmt.setInt(4, Integer.parseInt(unitprice));
			preparedStmt.setInt(5, Integer.parseInt(ID));
			
		

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the inquiries.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	public String deleteUnits(String unitsId) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "DELETE FROM units WHERE unitsId = ?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(unitsId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the Units details.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	


}

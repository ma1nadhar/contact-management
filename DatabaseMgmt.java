/* 
 * DatabaseMgmt.java
 * 
 * Maina Dhar
 * Java Project - Database
 * 
 * This java project connects to a database and manages contacts in a table.
 * This project incorporates and deletes contact details. It creates a connection
 * to the database and is able to add, delete, modify, and get contacts.
 * 
 */

import java.sql.*;

public class DatabaseMgmt {

	// connection to database
	public Connection DBConnect() {

		Connection con = null;

		try {

			// create instance of driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// database connection string
			String url = "jdbc:mysql://localhost:3306/contact_db";
			String un = "root";
			String password = "montfort";

			// getting connection by passing above
			con = DriverManager.getConnection(url, un, password);

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		// return connection
		return con;

	}

	// add contact
	public void insertContact(ContactProperty cp) {

		// instance of class
		DatabaseMgmt dbm = new DatabaseMgmt();

		// connecting to database
		Connection con = dbm.DBConnect();

		// insert querey
		// DATABASE
		String insertStatement = "insert into contact_tbl(name, gender, age, phone, address) values " + "(\"" + cp.name
				+ "\", \"" + cp.gender + "\"," + cp.age + ", \"" + cp.phonenum + "\", \"" + cp.address + "\")";

		System.out.println(insertStatement);

		try {
			// Standard step to create connection
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertStatement);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

	// shows all contacts in the database
	public void showContact() {

		// instance of class
		DatabaseMgmt dbm = new DatabaseMgmt();

		// connecting to database
		Connection con = dbm.DBConnect();
		String showStatement = "select * from contact_tbl";

		System.out.println(showStatement);

		try {
			// Standard step to create connection
			Statement stmt = con.createStatement();
			stmt.execute(showStatement);

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	// gets a specific contact given name
	public void getContact(String name) {

		// instance of class
		DatabaseMgmt dbm = new DatabaseMgmt();

		// connecting to database
		Connection con = dbm.DBConnect();
		String getStatement = "select name, age, gender, age, phone, address from contact_tbl where name = \"" + name
				+ "\"";

		System.out.println(getStatement);

		try {
			// Standard step to create connection
			Statement stmt = con.createStatement();
			stmt.execute(getStatement);

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	// deletes a contact given name
	public void deleteContact(String name) {

		// instance of class
		DatabaseMgmt dbm = new DatabaseMgmt();

		// connecting to database
		Connection con = dbm.DBConnect();
		String deleteStatement = "delete from contact_tbl where name = \"" + name + "\"";

		System.out.println(deleteStatement);

		try {
			// Standard step to create connection
			Statement stmt = con.createStatement();
			stmt.executeUpdate(deleteStatement);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

	// modifies a contact given name and what needs to be modified
	public void modifyContact(ContactProperty cp, String modifyWhat) {

		// instance of class
		DatabaseMgmt dbm = new DatabaseMgmt();

		// connecting to database
		Connection con = dbm.DBConnect();
		
		String modifyStatement = "";

		// modify options
		if (modifyWhat.equals("age")) {
			modifyStatement = "UPDATE contact_tbl SET age = " + cp.age + " where name = \"" + cp.name + "\"";	
		} else if (modifyWhat.equals("gender")) {
			modifyStatement = "UPDATE contact_tbl SET gender = \"" + cp.gender + "\" where name = \"" + cp.name + "\"";	
		} else if (modifyWhat.equals("address")) {
			modifyStatement = "UPDATE contact_tbl SET address = \"" + cp.address + "\" where name = \"" + cp.name + "\"";	
		} else if (modifyWhat.equals("phonenum")) {
			modifyStatement = "UPDATE contact_tbl SET phone = \"" + cp.phonenum + "\" where name = \"" + cp.name + "\"";	
		} else {
			
			
		}

		System.out.println(modifyStatement); 

		try {
			// Standard step to create connection
			Statement stmt = con.createStatement();
			stmt.executeUpdate(modifyStatement);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

}

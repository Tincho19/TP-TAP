package com.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DBTest {
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		String dbURL = "jdbc:sqlserver://127.0.0.1/TAPDataBase;integratedSecurity=true;";
		String user = "sa";
		String pass = "a66179";
		Connection conn = DriverManager.getConnection(dbURL, user, pass);
		System.out.println("test");
		Statement sta = conn.createStatement();
		String Sql = "select * from pedidos";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}
}
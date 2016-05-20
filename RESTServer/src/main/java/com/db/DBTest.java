package com.db;

import java.sql.*;
 
public class DBTest {
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String server = "TINCHO-T420\\SQLEXPRESS2012:1032";
		String user = "sa";
		String pass = "a66179";
		String dataBase = "TAPDataBase";
		String jdbcUrl = ("jdbc:sqlserver//"+server);
//		String jdbcUrl = ("jdbc:sqlserver//"+server+";user="+user+";password="+pass+";databaseName="+dataBase);
		Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.println("test");
		Statement sta = conn.createStatement();
		String Sql = "select * from Pedidos";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}
}
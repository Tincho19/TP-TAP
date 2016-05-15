package com.db;
import java.sql.*;

public class CreoTabla {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		// Archivo de texto donde se guarda la tabla
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:C:/TP-TAP/TablaPedidos.db", "sa", "");
		Statement stmt = conn.createStatement();
		// Creo una tabla
		String query = "CREATE TABLE pedido (id INT, nombre VARCHAR(50), calle VARCHAR(50), altura INT, piso VARCHAR(50), telefono VARCHAR(50), comida VARCHAR(50));"; // ansii92
		stmt.execute(query);
		stmt.execute("SHUTDOWN");
		conn.close();
	}

}

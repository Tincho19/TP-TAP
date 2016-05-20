package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.entities.Pedido;

public class ABMPedidos{
	
	Connection conn = null;
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:sqlserver://TINCHO-T420:1032//TAPDataBase";

	   //  Database credentials
	   static final String USER = "sa";
	   static final String PASS = "a66179";
	   
	private ABMPedidos(){
		try {
			
			
//				Class.forName("org.hsqldb.jdbcDriver");
//				conn = DriverManager.getConnection("jdbc:hsqldb:C:/TP-TAP/TablaPedidos.db", "sa", "");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String server = "TINCHO-T420\\SQLEXPRESS2012:1032";
				String user = "sa";
				String pass = "a66179";
				String dataBase = "TAPDataBase";
	//			String jdbcUrl = ("jdbc:sqlserver//"+server);
				String jdbcUrl = ("jdbc:sqlserver://"+server+";user="+user+";password="+pass+";databaseName="+dataBase);
				conn = DriverManager.getConnection(jdbcUrl);
				generarReporte();
				   
//				   Statement stmt = null;
//				      //STEP 2: Register JDBC driver
//					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				      //STEP 3: Open a connection
//				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static ABMPedidos instance;
	
	public static ABMPedidos getInstance(){
		if(instance == null){
			instance = new ABMPedidos();
		}
	return instance;
	}
	
	
	public void crearPedidoDB(Pedido pedido) {
		Statement stmt = null;
		try{		
			stmt = conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO pedido (id,nombre,calle,altura,piso,telefono,comida) VALUES (");
			query.append(pedido.getIdPedido());
			query.append(",'");
			query.append(pedido.getCliente().getNombre());
			query.append("','");
			query.append(pedido.getCliente().getDireccion().getCalle());
			query.append("',");
			query.append(pedido.getCliente().getDireccion().getAltura());
			query.append(",'");
			query.append(pedido.getCliente().getDireccion().getPiso());
			query.append("','");
			query.append(pedido.getCliente().getTelefono());
			query.append("','");
			query.append(pedido.getComida());
			query.append("');");
			
			
//			String insert = "INSERT INTO pedido (id,nombre,calle,altura,piso,comida) VALUES ('"+pedido.get+"','"+nombre+"','"+calle+"',"+altura+",'"+piso+"','"+comida+"');"; // ansii92
				stmt.executeUpdate(query.toString());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al insertar registro: "+e.getMessage()+"SQL error: "+e.getSQLState(),"titulo",JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void updatePedidoDB(Pedido pedido) {
		Statement stmt = null;
		try{		
			stmt = conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("UPDATE pedido SET comida = '");
			query.append(pedido.getComida());
			query.append("'");
			query.append("WHERE id = ");
			query.append(pedido.getIdPedido());
			query.append(";");
			
			stmt.executeUpdate(query.toString());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al actualizar registro: "+e.getMessage()+"SQL error: "+e.getSQLState(),"titulo",JOptionPane.ERROR_MESSAGE);
			}
	}

	public void deletePedidoDB(Pedido pedido) {
		Statement stmt = null;
		try{		
			stmt = conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("DELETE FROM pedido WHERE id = ");
			query.append(pedido.getIdPedido());
			query.append(";");
			
			stmt.executeUpdate(query.toString());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al insertar registro: "+e.getMessage()+"SQL error: "+e.getSQLState(),"titulo",JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public String generarReporte(){
		Statement stmt = null;
		String Resultado = "";
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM pedidos;");
			if(null != resultSet){
				while(resultSet.next()){
					String id = resultSet.getString("id");
					String nombre = resultSet.getString("nombre");
					String direccion = resultSet.getString("direccion");
					String telefono = resultSet.getString("telefono");
					String comida = resultSet.getString("comida");
					Resultado += (" // "+id+" "+nombre+" "+direccion+" "+telefono+" "+comida);
				}
			}else{
				System.out.println("no se encontraron resultados.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al conectarse a la base: "+e.getMessage()+"SQL error: "+e.getSQLState(),"titulo",JOptionPane.ERROR_MESSAGE);
		}
		return Resultado;
		
		
	}
	
}

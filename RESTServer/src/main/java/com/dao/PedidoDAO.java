package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.entities.Pedido;

public class PedidoDAO{
	
	Connection conn = null;
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  

	   //  Database credentials
	   static final String USER = "sa";
	   static final String PASS = "a66179";
	   static final String DATABASE = "TAPDataBase";
	   static final	String SERVER = "localhost\\SQLEXPRESS2012:1039";

	   
	private PedidoDAO(){
		try {	
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String jdbcUrl = ("jdbc:sqlserver://"+SERVER+";user="+USER+";password="+PASS+";databaseName="+DATABASE);
				conn = DriverManager.getConnection(jdbcUrl);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static PedidoDAO instance;
	
	public static PedidoDAO getInstance(){
		if(instance == null){
			instance = new PedidoDAO();
		}
	return instance;
	}
	
	
	public void crearPedidoDB(Pedido pedido) {
		Statement stmt = null;
		try{		
			stmt = conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO pedidos (id,nombre,direccion,telefono,comida) VALUES (");
			query.append(pedido.getIdPedido());
			query.append(",'");
			query.append(pedido.getCliente().getNombre());
			query.append("','");
			query.append(pedido.getCliente().getDireccion());
			query.append("','");
			query.append(pedido.getCliente().getTelefono());
			query.append("','");
			query.append(pedido.getComida());
			query.append("');");
			stmt.executeUpdate(query.toString());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al insertar registro: "+e.getMessage()+"SQL error: "+e.getSQLState(),"titulo",JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void modificarPedidoDB(Pedido pedido) {
		Statement stmt = null;
		try{		
			stmt = conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("UPDATE pedidos SET comida = '");
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

	public void eliminarPedidoDB(Pedido pedido) {
		Statement stmt = null;
		try{		
			stmt = conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("DELETE FROM pedidos WHERE id = ");
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

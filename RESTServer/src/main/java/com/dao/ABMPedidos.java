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
	
	private ABMPedidos(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:C:/TP-TAP/TablaPedidos.db", "sa", "");
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
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM pedido;");
			if(null != resultSet){
				while(resultSet.next()){
					String id = resultSet.getString("id");
					String nombre = resultSet.getString("nombre");
					String calle = resultSet.getString("calle");
					String altura = resultSet.getString("altura");
					String piso = resultSet.getString("piso");
					String telefono = resultSet.getString("telefono");
					String comida = resultSet.getString("comida");
					Resultado += (" // "+id+" "+nombre+" "+calle+" "+altura+" "+piso+" "+telefono+" "+comida);
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

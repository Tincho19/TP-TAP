package com.service;

import com.dao.PedidoDAO;
import com.entities.Pedido;

public class PedidoService implements IPedidoService {
	
	private PedidoDAO abmPedidos;
	
	public PedidoService(){
		abmPedidos = PedidoDAO.getInstance();
	}
	
	public void crearPedido(String nombre, String direccion, String telefono, String comida) {
		abmPedidos.crearPedidoDB(nombre, direccion, telefono, comida);
	}

	public void modificarPedido(int id_pedido, String comida) {
		abmPedidos.modificarPedidoDB(id_pedido, comida);
	}

	public void eliminarPedido(int id_pedido) {
		abmPedidos.eliminarPedidoDB(id_pedido);		
	}

	public String generarReporte() {
		return abmPedidos.generarReporte();
	}


}

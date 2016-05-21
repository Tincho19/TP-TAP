package com.service;


import com.dao.PedidoDAO;
import com.entities.Pedido;


public class PedidoService implements IPedidoService {
	
	private PedidoDAO abmPedidos;
	
	public PedidoService(){
		abmPedidos = PedidoDAO.getInstance();
	}
	
	public void crearPedido(Pedido pedido) {
		abmPedidos.crearPedidoDB(pedido);
	}

	public void modificarPedido(Pedido pedido) {
		abmPedidos.modificarPedidoDB(pedido);
	}

	public void eliminarPedido(Pedido pedido) {
		abmPedidos.eliminarPedidoDB(pedido);
		
	}

	public String generarReporte() {
		//System.out.println(abmPedidos.generarReporte());
		return abmPedidos.generarReporte();
	}

}

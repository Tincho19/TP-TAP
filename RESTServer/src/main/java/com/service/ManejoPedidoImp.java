package com.service;


import com.dao.ABMPedidos;
import com.entities.Pedido;


public class ManejoPedidoImp implements ManejoPedido {
	
	private ABMPedidos abmPedidos;
	
	public ManejoPedidoImp(){
		abmPedidos = ABMPedidos.getInstance();
	}
	
	public void crearPedido(Pedido pedido) {
		abmPedidos.crearPedidoDB(pedido);
	}

	public void modificarPedido(Pedido pedido) {
		abmPedidos.updatePedidoDB(pedido);
	}

	public void borrarPedido(Pedido pedido) {
		abmPedidos.deletePedidoDB(pedido);
		
	}

	public void generarReporte() {
		System.out.println(abmPedidos.generarReporte());
	}

}

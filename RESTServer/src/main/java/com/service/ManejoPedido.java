package com.service;



import com.entities.Pedido;

public interface ManejoPedido {
		
	public void crearPedido(Pedido pedido);
	public void modificarPedido(Pedido pedido);
	public void borrarPedido(Pedido pedido);
	public void generarReporte();

}

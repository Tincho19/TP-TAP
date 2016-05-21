package com.service;



import com.entities.Pedido;

public interface IPedidoService {
		
	public void crearPedido(Pedido pedido);
	public void modificarPedido(Pedido pedido);
	public void eliminarPedido(Pedido pedido);
	public String generarReporte();

}

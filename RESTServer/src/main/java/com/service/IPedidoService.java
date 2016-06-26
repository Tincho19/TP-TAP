package com.service;

public interface IPedidoService {
		
	public void crearPedido(String nombre, String direccion, String telefono, String comida);
	public void modificarPedido(int id_pedido, String comida);
	public void eliminarPedido(int id_pedido);
	public String generarReporte();

}

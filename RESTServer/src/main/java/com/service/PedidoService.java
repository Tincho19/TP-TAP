package com.service;

import com.dao.PedidoDAO;
import com.entities.Pedido;

public class PedidoService implements IPedidoService {
	
	private PedidoDAO abmPedidos;
	
	public PedidoService(){
		abmPedidos = PedidoDAO.getInstance();
	}
	
	public void crearPedido(String nombre, String direccion, String telefono, String comida) {
		Pedido pedido = new Pedido();
		pedido.setNombre("Jorge");
		pedido.setDireccion("Santa fe 2222");
		pedido.setTelefono("1215-1251");
		pedido.setComida("Ravioles");
		abmPedidos.crearPedidoDB(pedido.getNombre(), pedido.getDireccion(), pedido.getTelefono(), pedido.getComida());		
	}

	public void modificarPedido(int id_pedido, String comida) {
		Pedido pedido = new Pedido();
		pedido.setComida("Chauchas");
		pedido.setIdPedido(1);
		abmPedidos.modificarPedidoDB(pedido.getIdPedido(), pedido.getComida());
	}

	public void eliminarPedido(int id_pedido) {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(1);
		abmPedidos.eliminarPedidoDB(pedido.getIdPedido());		
	}

	public String generarReporte() {
		return abmPedidos.generarReporte();
	}


}

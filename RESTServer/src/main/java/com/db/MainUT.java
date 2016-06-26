package com.db;

import com.entities.Pedido;
import com.service.PedidoService;


public class MainUT {

	public static void main(String[] args) {
		
	// Creo Objetos	
	Pedido pedido1 = new Pedido();
	Pedido pedido2 = new Pedido();
	Pedido pedido3 = new Pedido();
	Pedido pedido4 = new Pedido();
	Pedido pedido5 = new Pedido();

	PedidoService orden = new PedidoService();	
	
	// Creo Clientes
	pedido1.setNombre("Pepe");
	pedido1.setTelefono("4732-2632");
	pedido1.setDireccion("Mario Bravo 1050");
	pedido2.setNombre("Juan");
	pedido2.setTelefono("4744-5555");
	pedido2.setDireccion("Santa fe 2060");
	pedido3.setNombre("Pedro");
	pedido3.setTelefono("4832-1010");
	pedido3.setDireccion("Juncal 2010");
	
	// Creo pedidos
	pedido1.setComida("Milanesas con pure");
	pedido2.setComida("3 pizzas grandes de muzzarella");
	pedido3.setComida("2 docenas de empanadas");
	pedido4.setComida("Hamburguesa completa con papas fritas");
	pedido5.setComida("Ensalada elite suprema");
	
	// Borro el contenido de la base de datos
	//orden.eliminarPedido(pedido1);
	//orden.eliminarPedido(pedido2);
	//orden.eliminarPedido(pedido3);
	//orden.eliminarPedido(pedido4);
	//orden.eliminarPedido(pedido5);
	
	/* Doy de alta los pedidos
	orden.crearPedido(pedido1);
	orden.crearPedido(pedido2);
	orden.crearPedido(pedido3);
	orden.crearPedido(pedido4);
	orden.crearPedido(pedido5);
	
	//Modofico pedidos 
	pedido1.setComida("fideos");
	orden.modificarPedido(pedido1);
	pedido2.setComida("3 empanadas");
	orden.modificarPedido(pedido2);
	*/
	// Muestro Pedidos
	System.out.println(orden.generarReporte());
	}
	
}

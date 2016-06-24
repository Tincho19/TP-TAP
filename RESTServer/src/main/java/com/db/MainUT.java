package com.db;

import com.entities.Cliente;
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
	Cliente cli1 = new Cliente();
	Cliente cli2 = new Cliente();
	Cliente cli3 = new Cliente();
	PedidoService orden = new PedidoService();	
	
	// Creo Clientes
	cli1.setNombre("Pepe");
	cli1.setTelefono("4732-2632");
	cli1.setDireccion("Mario Bravo 1050");
	cli2.setNombre("Juan");
	cli2.setTelefono("4744-5555");
	cli2.setDireccion("Santa fe 2060");
	cli3.setNombre("Pedro");
	cli3.setTelefono("4832-1010");
	cli3.setDireccion("Juncal 2010");
	
	// Creo pedidos
	pedido1.setComida("Milanesas con pure");
	pedido1.setCliente(cli1);
	pedido2.setComida("3 pizzas grandes de muzzarella");
	pedido2.setCliente(cli2);
	pedido3.setComida("2 docenas de empanadas");
	pedido3.setCliente(cli3);
	pedido4.setComida("Hamburguesa completa con papas fritas");
	pedido4.setCliente(cli2);
	pedido5.setComida("Ensalada elite suprema");
	pedido5.setCliente(cli1);
	
	// Borro el contenido de la base de datos
	//orden.eliminarPedido(pedido1);
	//orden.eliminarPedido(pedido2);
	//orden.eliminarPedido(pedido3);
	//orden.eliminarPedido(pedido4);
	//orden.eliminarPedido(pedido5);
	
	// Doy de alta los pedidos
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
	
	// Muestro Pedidos
	System.out.println(orden.generarReporte());
	}
	
}

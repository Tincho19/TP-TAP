package com.db;

import com.entities.Cliente;
import com.entities.Direccion;
import com.entities.Pedido;
import com.service.ManejoPedidoImp;


public class Main {

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
	Direccion dir1 = new Direccion();
	Direccion dir2 = new Direccion();
	Direccion dir3 = new Direccion();
	ManejoPedidoImp orden = new ManejoPedidoImp();
	
//	// Borro el contenido de la base de datos
//	orden.borrarPedido(pedido1);
//	orden.borrarPedido(pedido2);
//	orden.borrarPedido(pedido3);
//	orden.borrarPedido(pedido4);
//	orden.borrarPedido(pedido5);
//	
//	// Creo direcciones
//	dir1.setCalle("Mario Bravo");
//	dir1.setAltura(1050);
//	dir1.setPiso("4D");
//	dir2.setCalle("Av. Santa Fe");
//	dir2.setAltura(3550);
//	dir2.setPiso("");
//	dir3.setCalle("Av. Cordoba");
//	dir3.setAltura(2250);
//	dir3.setPiso("PB D");
//	
//	// Creo Clientes
//	cli1.setNombre("Pepe");
//	cli1.setTelefono("4732-2632");
//	cli1.setDireccion(dir1);
//	cli2.setNombre("Juan");
//	cli2.setTelefono("4744-5555");
//	cli2.setDireccion(dir2);
//	cli3.setNombre("Pedro");
//	cli3.setTelefono("4832-1010");
//	cli3.setDireccion(dir3);
//	
//	// Creo pedidos
//	pedido1.setIdPedido(1);
//	pedido1.setComida("Milanesas con pure");
//	pedido1.setCliente(cli1);
//	pedido2.setIdPedido(2);
//	pedido2.setComida("3 pizzas grandes de muzzarella");
//	pedido2.setCliente(cli2);
//	pedido3.setIdPedido(3);
//	pedido3.setComida("2 docenas de empanadas");
//	pedido3.setCliente(cli3);
//	pedido4.setIdPedido(4);
//	pedido4.setComida("Hamburguesa completa con papas fritas");
//	pedido4.setCliente(cli2);
//	pedido5.setIdPedido(5);
//	pedido5.setComida("Ensalada elite suprema");
//	pedido5.setCliente(cli1);
//	
//	// Doy de alta los pedidos
//	orden.crearPedido(pedido1);
//	orden.crearPedido(pedido2);
//	orden.crearPedido(pedido3);
//	orden.crearPedido(pedido4);
//	orden.crearPedido(pedido5);
//	
//	//Modofico pedidos 
//	pedido1.setComida("fideos");
//	orden.modificarPedido(pedido1);
//	pedido2.setComida("3 empanadas");
//	orden.modificarPedido(pedido2);
	
	// Muestro Pedidos
	orden.generarReporte();
	
	}
	
}

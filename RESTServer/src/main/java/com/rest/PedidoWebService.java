package com.rest;

// Url: http://localhost:8090/RESTServer/rest/pedido/?

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entities.Cliente;
import com.entities.Pedido;
import com.service.IPedidoService;
import com.service.PedidoService;

@Path("/pedido")
public class PedidoWebService {

	private IPedidoService manejoPedido = new PedidoService();
		
	private static final String OK = "OK";
	
	@GET
	@Path("/borrar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String borrarPedido(@PathParam("id") String id) { 		
		Pedido p = new Pedido();
		p.setIdPedido(Integer.valueOf(id).intValue());
		manejoPedido.eliminarPedido(p);

		return OK;
	}

	@GET
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearPedido() { 		
		Pedido p = new Pedido();
		Cliente c = new Cliente();
		c.setNombre("Juan Web");
		c.setDireccion("Mario Bravo Web");
		c.setTelefono("4626-2626");
		p.setComida("Empanadas Web");
		p.setCliente(c);
		manejoPedido.crearPedido(p);
		return OK;
	}
	
	@GET
	@Path("/modificar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String modificarPedido(@PathParam("id") String id) { 		
		Pedido p = new Pedido();
		p.setIdPedido(Integer.valueOf(id).intValue());
		p.setComida("Locro Web");
		manejoPedido.modificarPedido(p);
		return OK;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String listarPedidos() {
		return manejoPedido.generarReporte();
	}

}

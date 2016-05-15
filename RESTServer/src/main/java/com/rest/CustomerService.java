package com.rest;

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

import com.entities.Pedido;
import com.service.ManejoPedido;
import com.service.ManejoPedidoImp;

@Path("/customer")
public class CustomerService {

	private ManejoPedido manejoPedido = new ManejoPedidoImp();
		
	private static final String OK = "OK";

	
	
	@GET
	@Path("/borrar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String borrarPedido(@PathParam("id") String id) { 		
//		Customer c = new Customer();
//		
//		c.setFirstName("John");
//		c.setLastName("Connor");
//		c.setIdCustomer(25);
		Pedido p = new Pedido();
		p.setIdPedido(Integer.valueOf(id).intValue());
		manejoPedido.borrarPedido(p);

		return OK;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getListCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer c = new Customer();
		c.setFirstName("Bart");
		c.setLastName("Simpson");
		c.setIdCustomer(25);
		
		customers.add(c);
		
		c = new Customer();
		c.setFirstName("Marge");
		c.setLastName("Simpson");
		c.setIdCustomer(25);
		
		customers.add(c);
		
		return customers;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCustomer(Customer customer) {
		String s = "Se grabo el cliente: ";
		s += customer.getFirstName() + " " + customer.getLastName();
		
		return Response.status(201).entity(s).build();	//201 - Created
	}
}

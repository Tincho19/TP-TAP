package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWordService {
	
	@GET
	@Path("/{msg}")
	public Response getCustomer(@PathParam("msg") String msg) {
 		
		String output = "Hello : " + msg;
 
		return Response.status(200).entity(output).build();		//200 - Ok
	}
	
}

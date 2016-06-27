package com.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pedido")
public class AnnotationServer implements com.rest.DoStuff {

    com.rest.myAnnotation.AnnotationRest objAnnotationRest = new com.rest.myAnnotation.AnnotationRest();

    @GET
    @Path("/listado")
    @Produces(MediaType.APPLICATION_JSON)
    public java.lang.String getPedidos(){
        return  objAnnotationRest.getPedidos();
    }

    @POST
    @Path("/crear/{parametros}")
    public void crearPedido(@PathParam("parametros") String parametros){
          objAnnotationRest.crearPedido(parametros);
    }

    @POST
    @Path("/modificar/{parametros}")
    public void modificarPedido(@PathParam("parametros") String parametros){
          objAnnotationRest.modificarPedido(parametros);
    }

    @DELETE
    @Path("/eliminar/{parametros}")
    public void eliminarPedido(@PathParam("parametros") String parametros){
          objAnnotationRest.eliminarPedido(parametros);
    }
}

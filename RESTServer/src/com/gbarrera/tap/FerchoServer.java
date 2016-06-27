package com.gbarrera.tap;

import com.gbarrera.tap.DoStuff;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pedido")
public class FerchoServer implements com.gbarrera.tap.DoStuff {

    com.gbarrera.tap.server.Fercho objFercho = new com.gbarrera.tap.server.Fercho();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public java.lang.String getNombre(@PathParam("id") String id) {
        return  objFercho.getNombre(id);
    }

    @POST
    @Path("/crear/{parametros}")
    public void crearPedido(@PathParam("parametros") String parametros){
          objFercho.crearPedido(parametros);
    }
}

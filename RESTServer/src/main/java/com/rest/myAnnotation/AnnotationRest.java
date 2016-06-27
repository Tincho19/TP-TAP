package com.rest.myAnnotation;

import com.rest.MethodType;
import com.rest.PublishMethod;
import com.service.PedidoService;

public class AnnotationRest {
	
	@PublishMethod(type=MethodType.GET, id=true)
	public String getPedidos(){
		PedidoService ordenes = new PedidoService();
		System.out.println(ordenes.generarReporte());
		return ordenes.generarReporte();
	}
	
	@PublishMethod(type=MethodType.POST, id=true)
	public void crearPedido(String parametros){
		String[] params = parametros.split(";");
		int i=0;
		for (String string : params) {
			System.out.println("Parametro :"+i+" = "+string);
		}
		PedidoService orden = new PedidoService();
		orden.crearPedido(params[0], params[1], params[2], params[3]);
	}
	
	@PublishMethod(type=MethodType.POST, id=false)
	public void modificarPedido(String parametros){
		String[] params = parametros.split(";");
		int i=0;
		for (String string : params) {
			System.out.println("Parametro :"+i+" = "+string);
		}
		PedidoService orden = new PedidoService();
		orden.modificarPedido(Integer.parseInt(params[0]), params[1]);
	}
	
	@PublishMethod(type=MethodType.DELETE, id=true)
	public void eliminarPedido(String parametros){
		PedidoService orden = new PedidoService();
		orden.eliminarPedido(Integer.parseInt(parametros));
	}

}

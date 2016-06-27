package com.rest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.PathParam;


public class ServerClass {
	private String serverClassName;
	private ArrayList<Method> methods;
	
	private HashMap<String, Class<?>> logicClasses;
	
	public String getServerClassName() {
		return serverClassName;
	}

	public ArrayList<Method> getMethods() {
		return methods;
	}
	
	public HashMap<String, Class<?>> getLogicClasses() {
		return logicClasses;
	}
	
	
	public ServerClass(String serverClassName) {
		this.serverClassName = serverClassName;
		methods = new ArrayList<>();
		logicClasses = new HashMap<>();
	}
	
	public String buildJavaCode() {
		String code = ""; 
		
		code += "package com.rest;\n";
		code += "\n";
//		code += "import com.gbarrera.tap.DoStuff;\n";
		code += "import javax.ws.rs.DELETE;\n";
		code += "import javax.ws.rs.GET;\n";
		code += "import javax.ws.rs.POST;\n";
		code += "import javax.ws.rs.Path;\n";
		code += "import javax.ws.rs.PathParam;\n";
		code += "import javax.ws.rs.Produces;\n";
		code += "import javax.ws.rs.core.MediaType;\n";
//		code += "import javax.ws.rs.core.Response;\n";
		code += "\n";
		code += "@Path(\"/pedido\")\n";
		code += "public class " + this.serverClassName + " implements com.rest.DoStuff {\n";
		code += "\n";
		
		String serviceName="";
		for(Class<?> logicClass : this.logicClasses.values()) {
			serviceName = " obj" + logicClass.getSimpleName() ;
			code += "    " + logicClass.getName() + " obj" + logicClass.getSimpleName() + " = new " + logicClass.getName() + "();\n";
		}
		
		for(Method method : methods) {

			code += "\n";
			
			PublishMethod publishMethodAnnotation = (PublishMethod)method.getDeclaredAnnotation(PublishMethod.class);
			
			switch(publishMethodAnnotation.type()){
			case GET:
				if(publishMethodAnnotation.id())
					code += buildGetMethod(method, serviceName);
				break;
			case POST:
				if(publishMethodAnnotation.id())
					code += buildPostCrearMethod(method, serviceName);
				else
					code += buildPostModificarMethod(method, serviceName);
				break;
			case DELETE:
				if(publishMethodAnnotation.id())
					code += buildDeleteMethod(method, serviceName);
				break;
			case PUT:
				if(publishMethodAnnotation.id())
					code += buildPutMethod(method, serviceName);
				break;
			}
		}
		
		code += "}\n";
		
		return code;
	}

	private String buildGetMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Listar pedidos
		methodCode += "    @GET\n";
		methodCode += "    @Path(\"/listado\")\n";
		methodCode += "    @Produces(MediaType.APPLICATION_JSON)\n";
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(){\n";		
		methodCode += "        return "+serviceName+".getPedidos();\n";
		methodCode += "    }\n"; 
		
		return methodCode;
	}
	
	private String buildPostCrearMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Crear Pedido
		methodCode += "    @POST\n";
		methodCode += "    @Path(\"/crear/{parametros}\")\n";
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(";		
		methodCode += "@PathParam(\"parametros\") String parametros){\n";
		methodCode += "         "+serviceName+".crearPedido(parametros);\n";
		methodCode += "    }\n"; 
		
		return methodCode;
	}
	
	private String buildPostModificarMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Modificar Pedido
		methodCode += "    @POST\n";
		methodCode += "    @Path(\"/modificar/{parametros}\")\n";
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(";		
		methodCode += "@PathParam(\"parametros\") String parametros){\n";
		methodCode += "         "+serviceName+".modificarPedido(parametros);\n";
		methodCode += "    }\n"; 
		
		return methodCode;
	}

	private String buildDeleteMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Eliminar Pedido
		methodCode += "    @DELETE\n";
		methodCode += "    @Path(\"/eliminar/{parametros}\")\n";
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(";		
		methodCode += "@PathParam(\"parametros\") String parametros){\n";
		methodCode += "         "+serviceName+".eliminarPedido(parametros);\n";
		methodCode += "    }\n"; 		
		
		return methodCode;
	}

	private String buildPutMethod(Method method, String serviceName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

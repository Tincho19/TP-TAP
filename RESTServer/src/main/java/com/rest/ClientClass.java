package com.rest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;



public class ClientClass {
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
	
	
	public ClientClass(String serverClassName) {
		this.serverClassName = serverClassName;
		methods = new ArrayList<>();
		logicClasses = new HashMap<>();
	}
	
	public String buildJavaCode() {
		String code = ""; 
		
		code += "package com.rest;\n";
		code += "\n";
		code += "import java.io.BufferedReader;\n";
		code += "import java.io.InputStreamReader;\n";
		code += "import org.apache.http.HttpResponse;\n";
		code += "import org.apache.http.client.HttpClient;\n";
		code += "import org.apache.http.client.methods.HttpGet;\n";
		code += "import org.apache.http.client.methods.HttpPost;\n";
		code += "import org.apache.http.client.methods.HttpDelete;\n";
		code += "import org.apache.http.impl.client.HttpClientBuilder;\n";
		code += "\n";
		code += "public class Proxy {\n";
		code += "\n";
		
		String serviceName="";
		for(Class<?> logicClass : this.logicClasses.values()) {
			serviceName = " obj" + logicClass.getSimpleName() ;
	//		code += "    " + logicClass.getName() + " obj" + logicClass.getSimpleName() + " = new " + logicClass.getName() + "();\n";
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
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "() throws Exception{\n";
		methodCode += "	   String url = \"http://localhost:8090/RESTServer/rest/pedido/list\";\n";
		methodCode += "	   HttpClient client = HttpClientBuilder.create().build();\n";
		methodCode += "	   HttpGet request = new HttpGet(url);\n";
		methodCode += "	   HttpResponse response = client.execute(request);\n";
		methodCode += "	   System.out.println(\"Response Code : \" + response.getStatusLine().getStatusCode());\n";
		methodCode += "	   BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));\n";
		methodCode += "	   StringBuffer result = new StringBuffer();\n";
		methodCode += "	   result.append(rd.readLine());\n";
		methodCode += "        return result.toString();\n";
		methodCode += "    }\n"; 
		
		return methodCode;
	}
	
	private String buildPostCrearMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Crear Pedido
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(String param0) throws Exception{\n";
		methodCode += "	   String url = \"http://localhost:8090/RESTServer/rest/pedido/crear\" + \"/\" + param0.toString();\n";
		methodCode += "    HttpClient client = HttpClientBuilder.create().build();\n";
		methodCode += "    HttpPost request = new HttpPost(url);\n";
		methodCode += "    request.addHeader(\"Content-Type \", \"application/json\");\n";
		methodCode += "    HttpResponse response = client.execute(request);\n";
		methodCode += "    System.out.println(\"Response Code : \" + response.getStatusLine().getStatusCode());\n";
		methodCode += "    }\n"; 
		
		return methodCode;
	}
	
	private String buildPostModificarMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Modificar Pedido
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(String param0) throws Exception{\n";
		methodCode += "    String url = \"http://localhost:8090/RESTServer/rest/pedido/modificar\" + \"/\" + param0.toString();\n";
		methodCode += "    HttpClient client = HttpClientBuilder.create().build();\n";
		methodCode += "    HttpPost request = new HttpPost(url);\n";
		methodCode += "    request.addHeader(\"Content-Type\", \"application/json\");\n";
		methodCode += "    HttpResponse response = client.execute(request);\n";
		methodCode += "    System.out.println(\"Response Code : \" + response.getStatusLine().getStatusCode());\n";
		methodCode += "    }\n"; 
		
		return methodCode;
	}

	private String buildDeleteMethod(Method method, String serviceName) {
		String methodCode = "";
		
		// Eliminar Pedido
		methodCode += "    public " + method.getReturnType().getTypeName() + " " +  method.getName() + "(String param0) throws Exception{\n";
		methodCode += "    String url = \"http://localhost:8090/RESTServer/rest/pedido/borrar\" + \"/\" + param0.toString();\n";
		methodCode += "    HttpClient client = HttpClientBuilder.create().build();\n";
		methodCode += "    HttpDelete request = new HttpDelete(url);\n";
		
		methodCode += "    HttpResponse response = client.execute(request);\n";
		methodCode += "    System.out.println(\"Response Code : \" + response.getStatusLine().getStatusCode());\n";
		
		methodCode += "    }\n"; 		
		
		return methodCode;
	}

	private String buildPutMethod(Method method, String serviceName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

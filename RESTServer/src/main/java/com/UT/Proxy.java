package com.UT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;


public class Proxy {

	//private ObjectMapper mapper;
	//public Proxy(){mapper = new ObjectMapper();}


	/*
	public void finalizarConsulta(java.lang.Integer param0) throws Exception {
		String url = "http://localhost:8080/service/finalizar" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}

	*/
	
	public void eliminarPedido(String param0) throws Exception {
		String url = "http://localhost:8090/RESTServer/rest/pedido/borrar" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete(url);
		
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}
	
	public void modificarPedido(String param0) throws Exception {
		String url = "http://localhost:8090/RESTServer/rest/pedido/modificar" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}

	//public ArrayList<com.tp.up.client.model.Consultation> getConsultations() throws Exception {
	public String getPedidos() throws Exception {
		String url = "http://localhost:8090/RESTServer/rest/pedido/list";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		result.append(rd.readLine());
		
		/*
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		*/
		//ArrayList<com.tp.up.client.model.Consultation> myObjects = mapper.readValue(result.toString(), new TypeReference<ArrayList<com.tp.up.client.model.Consultation>>(){});
		return 	result.toString();
	}

	/*
	public void atender(java.lang.Integer param0) throws Exception {
		String url = "http://localhost:8080/service/atender" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}
	*/

	public void crearPedido(String param0) throws Exception {
		String url = "http://localhost:8090/RESTServer/rest/pedido/crear" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
		/*
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		Integer myObjects = mapper.readValue(result.toString(), new TypeReference<Integer>(){});
		return myObjects;
		*/
	}

	/*
	public ArrayList<com.tp.up.client.model.Pacient> getPatients() throws Exception {
		String url = "http://localhost:8080/service/patients";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		ArrayList<com.tp.up.client.model.Pacient> myObjects = mapper.readValue(result.toString(), new TypeReference<ArrayList<com.tp.up.client.model.Pacient>>(){});
		return myObjects;
	}

	public void crearPaciente(java.lang.String param0, java.lang.Integer param1, java.lang.String param2) throws Exception {
		String url = "http://localhost:8080/service/create/pacient" + "/" + param0.toString() + "/" + param1.toString() + "/" + param2.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}
	*/
}
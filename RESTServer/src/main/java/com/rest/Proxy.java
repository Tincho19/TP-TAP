package com.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

public class Proxy {


    public java.lang.String getPedidos() throws Exception{
	   String url = "http://localhost:8090/RESTServer/rest/pedido/list";
	   HttpClient client = HttpClientBuilder.create().build();
	   HttpGet request = new HttpGet(url);
	   HttpResponse response = client.execute(request);
	   System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
	   BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	   StringBuffer result = new StringBuffer();
	   result.append(rd.readLine());
        return result.toString();
    }

    public void crearPedido(String param0) throws Exception{
	   String url = "http://localhost:8090/RESTServer/rest/pedido/crear" + "/" + param0.toString();
    HttpClient client = HttpClientBuilder.create().build();
    HttpPost request = new HttpPost(url);
    request.addHeader("Content-Type ", "application/json");
    HttpResponse response = client.execute(request);
    System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
    }

    public void modificarPedido(String param0) throws Exception{
    String url = "http://localhost:8090/RESTServer/rest/pedido/modificar" + "/" + param0.toString();
    HttpClient client = HttpClientBuilder.create().build();
    HttpPost request = new HttpPost(url);
    request.addHeader("Content-Type", "application/json");
    HttpResponse response = client.execute(request);
    System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
    }

    public void eliminarPedido(String param0) throws Exception{
    String url = "http://localhost:8090/RESTServer/rest/pedido/borrar" + "/" + param0.toString();
    HttpClient client = HttpClientBuilder.create().build();
    HttpDelete request = new HttpDelete(url);
    HttpResponse response = client.execute(request);
    System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
    }
}

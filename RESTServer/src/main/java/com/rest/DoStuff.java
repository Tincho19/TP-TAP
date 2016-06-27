package com.rest;

public  interface DoStuff {
    
    public void crearPedido(String params);
    
    public void modificarPedido(String params);

	public void eliminarPedido(String params);

	public String getPedidos();

}
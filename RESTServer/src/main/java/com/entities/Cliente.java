package com.entities;

public class Cliente {
	
	private long id;
	private String nombre;
	private Direccion direccion;
	private String telefono;
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}

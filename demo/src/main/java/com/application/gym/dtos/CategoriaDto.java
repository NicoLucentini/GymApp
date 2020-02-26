package com.application.gym.dtos;

import java.io.Serializable;

public class CategoriaDto implements Serializable{

	private String nombre;
	private String descripcion;
	private String id;
	
	public CategoriaDto(String nombre, String descripcion, String id) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CategoriaDto() {}
	public CategoriaDto(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

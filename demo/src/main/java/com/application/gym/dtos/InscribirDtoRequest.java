package com.application.gym.dtos;

import java.io.Serializable;

public class InscribirDtoRequest implements Serializable{
	public String idClase;
	public String idAlumno;
	
	public InscribirDtoRequest() {
		
	}
	
	public String getIdClase() {
		return idClase;
	}
	public void setIdClase(String idClase) {
		this.idClase = idClase;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	
}

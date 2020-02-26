package com.application.gym.dtos;

import java.io.Serializable;
import java.util.Date;

import com.application.gym.entities.Categoria;

public class ClaseDto implements Serializable {
	
	private Date horarioInicio;
	private Date horarioFin;
	private String fk_profesor; // profesor
	private String fk_categoria;
	private Integer cantidadAlumnos;
	
	public ClaseDto() {}
	
	
	public ClaseDto(Date horarioInicio, Date horarioFin, String fk_profesor, String fk_categoria, Integer cantidadAlumnos) {
		super();
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
		this.fk_profesor = fk_profesor;
		this.fk_categoria = fk_categoria;
		this.cantidadAlumnos = cantidadAlumnos;
	}


	public Date getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Date getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(Date horarioFin) {
		this.horarioFin = horarioFin;
	}
	public String getFk_profesor() {
		return fk_profesor;
	}
	public void setFk_profesor(String fk_profesor) {
		this.fk_profesor = fk_profesor;
	}
	public String getFk_categoria() {
		return fk_categoria;
	}
	public void setFk_categoria(String fk_categoria) {
		this.fk_categoria = fk_categoria;
	}
	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}
	public void setCantidadAlumnos(Integer cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}


	

}

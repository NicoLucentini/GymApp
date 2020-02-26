package com.application.gym.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clase_y_alumnos")
public class ClaseYAlumnos {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="fk_clase")
	private Clase fk_clase;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="fk_alumno")
	private Usuario fk_alumno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clase getFk_clase() {
		return fk_clase;
	}

	public void setFk_clase(Clase fk_clase) {
		this.fk_clase = fk_clase;
	}

	public Usuario getFk_alumno() {
		return fk_alumno;
	}

	public void setFk_alumno(Usuario fk_alumno) {
		this.fk_alumno = fk_alumno;
	}

	
	
}

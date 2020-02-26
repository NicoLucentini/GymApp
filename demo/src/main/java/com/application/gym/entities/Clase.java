package com.application.gym.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clases")
public class Clase {
	
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
  
   @Column(name = "horarioInicio")
	private Date horarioInicio;
  
   @Column(name = "horarioFin")
	private Date horarioFin;
  
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = true)
    @JoinColumn(name="FK_PROFESOR")
	private Usuario profesor;
  
   // @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = true)
	@JoinColumn(name="FK_CATEGORIA")
	private Categoria categoria;
	
	@Column(name = "cantidadAlumnos")
	private int cantidadAlumnos;
	
	public Clase() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getProfesor() {
		return profesor;
	}

	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	
	
	
}

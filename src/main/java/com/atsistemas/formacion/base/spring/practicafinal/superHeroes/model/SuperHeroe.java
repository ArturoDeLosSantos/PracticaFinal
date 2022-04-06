package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="SUPERHEROE")
public class SuperHeroe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ESTADO")
	private String estado;
	
	public SuperHeroe() {
		super();
	}

	public SuperHeroe(Integer id, String nombre, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}

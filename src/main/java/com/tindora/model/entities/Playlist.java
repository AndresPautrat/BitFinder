package com.tindora.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name= "playlists")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=1,message="El nombre de la playlist debe de tener como minimo 1 caracter")
	@Column(name="nombre",nullable = true)
	private String nombre;
	
	@Column(name="cantidadReprodu")
	private Integer cantidadReprodu;

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

	public Integer getCantidadReprodu() {
		return cantidadReprodu;
	}

	public void setCantidadReprodu(Integer cantidadReprodu) {
		this.cantidadReprodu = cantidadReprodu;
	}
	
	
}

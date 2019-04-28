package com.tindora.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(GeneroUsuarioPK.class)
@Table(name="genero_usuario")
public class GeneroUsuario {
	@Id
	private Genero genero;
	
	@Id
	private Usuario usuario;
	
	@Column(name="cantidad_reproduccion",nullable=false,length=9^10)
	private Integer canidadReproduccion;

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getCanidadReproduccion() {
		return canidadReproduccion;
	}

	public void setCanidadReproduccion(Integer canidadReproduccion) {
		this.canidadReproduccion = canidadReproduccion;
	}

}

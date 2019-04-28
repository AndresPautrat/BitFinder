package com.tindora.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@IdClass(ArtistaUsuarioPK.class)
@Table(name="artista_usuario")
public class ArtistaUsuario {
	@Id
	private Artista artista;
	
	@Id
	private Usuario usuario;
	
	@Column(name="cantidad_Reproduccion",nullable=true,length = 9^10 )
	private Integer cantidadReproduccion;

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getCantidadReproduccion() {
		return cantidadReproduccion;
	}

	public void setCantidadReproduccion(Integer cantidadReproduccion) {
		this.cantidadReproduccion = cantidadReproduccion;
	}
	
}

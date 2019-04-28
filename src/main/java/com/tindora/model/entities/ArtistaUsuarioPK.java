package com.tindora.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ArtistaUsuarioPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="artista_id",nullable=false)
	private Artista artista;
	
	@ManyToOne
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;
	
	
}

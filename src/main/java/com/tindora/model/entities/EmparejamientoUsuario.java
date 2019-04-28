package com.tindora.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(EmparejamientoUsuarioPK.class)
@Table(name = "emparejamiento_usuario")
public class EmparejamientoUsuario {
	@Id
	private Emparejamiento emparejamiento;

	@Id
	private Usuario usuario;

	public Emparejamiento getEmparejamiento() {
		return emparejamiento;
	}

	public void setEmparejamiento(Emparejamiento emparejamiento) {
		this.emparejamiento = emparejamiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

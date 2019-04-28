package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Emparejamiento;
import com.tindora.model.entities.Usuario;

public class UsuarioListaEmparejamientoDTO {

	private Usuario usuario;
	private List<Emparejamiento> emparejamientos;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Emparejamiento> getEmparejamientos() {
		return emparejamientos;
	}
	public void setEmparejamientos(List<Emparejamiento> emparejamientos) {
		this.emparejamientos = emparejamientos;
	}
	
	
}

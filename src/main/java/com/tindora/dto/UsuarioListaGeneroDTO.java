package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Genero;
import com.tindora.model.entities.Usuario;

public class UsuarioListaGeneroDTO {

	private Usuario usuario;
	private List<Genero> generos;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	
	
}

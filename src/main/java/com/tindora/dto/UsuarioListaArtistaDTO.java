package com.tindora.dto;


import java.util.List;

import com.tindora.model.entities.Artista;
import com.tindora.model.entities.Usuario;

public class UsuarioListaArtistaDTO {

	private Usuario usuario;
	private List<Artista> artistas ;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Artista> getArtistas() {
		return artistas;
	}
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	
	
	
}

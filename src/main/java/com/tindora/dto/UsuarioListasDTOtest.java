package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Artista;
import com.tindora.model.entities.Genero;
import com.tindora.model.entities.Playlist;
import com.tindora.model.entities.Rol;
import com.tindora.model.entities.Usuario;

public class UsuarioListasDTOtest {

	private Usuario usuario;
	private List<Rol> roles;
	private List<Playlist> playlists;
	private List<Genero> generos;
	private List<Artista> artistas ;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	public List<Artista> getArtistas() {
		return artistas;
	}
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	
	
	
}

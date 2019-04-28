package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Playlist;
import com.tindora.model.entities.Usuario;

public class UsuarioListaPlaylistDTO {

	private Usuario usuario;
	private List<Playlist> playlists;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	
}

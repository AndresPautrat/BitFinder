package com.tindora.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UsuarioPlaylistPK.class)
@Table(name= "usuario_playlist")
public class UsuarioPlaylist {
	@Id
	private Usuario usuario;
	@Id
	private Playlist playlist;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
}

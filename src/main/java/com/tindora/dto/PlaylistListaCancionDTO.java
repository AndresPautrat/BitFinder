package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Cancion;
import com.tindora.model.entities.Playlist;

public class PlaylistListaCancionDTO {

	private Playlist playlist;
	private List<Cancion> canciones;
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	public List<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
	
}

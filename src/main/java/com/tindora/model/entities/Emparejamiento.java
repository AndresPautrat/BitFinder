package com.tindora.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emparejamientos")
public class Emparejamiento {

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "artista_id", nullable = false)
	private Artista artista;

	@ManyToOne
	@JoinColumn(name = "genero_id", nullable = false)
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "playlist_id", nullable = false)
	private Playlist playlist;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

}

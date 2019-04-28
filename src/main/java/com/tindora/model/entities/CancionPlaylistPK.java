package com.tindora.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CancionPlaylistPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cancion_id", nullable = false)
	private Cancion cancion;

	@ManyToOne
	@JoinColumn(name = "playlist_id", nullable = false)
	private Playlist playlist;

}

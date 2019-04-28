package com.tindora.service;

import com.tindora.dto.PlaylistListaCancionDTO;
import com.tindora.model.entities.Playlist;

public interface PlaylistService extends CrudService<Playlist>{

	Playlist registrar(PlaylistListaCancionDTO playlistCancionDTO);
}

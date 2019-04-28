package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.dto.PlaylistListaCancionDTO;
import com.tindora.model.entities.Playlist;
import com.tindora.model.repository.CancionPlaylistRepository;
import com.tindora.model.repository.PlaylistRepository;
import com.tindora.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;
	@Autowired
	private CancionPlaylistRepository cancionPlaylistRepository;
	@Override
	public Playlist registrar(Playlist t) {
		// TODO Auto-generated method stub
		return playlistRepository.save(t);
	}

	@Override
	public Playlist modificar(Playlist t) {
		// TODO Auto-generated method stub
		return playlistRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		playlistRepository.deleteById(id);
	}

	@Override
	public List<Playlist> listar() {
		// TODO Auto-generated method stub
		return playlistRepository.findAll();
	}

	@Override
	public Optional<Playlist> listID(int id) {
		// TODO Auto-generated method stub
		return playlistRepository.findById(id);
	}

	@Override
	public Playlist registrar(PlaylistListaCancionDTO playlistCancionDTO) {
		playlistRepository.save(playlistCancionDTO.getPlaylist()) ;
		
		playlistCancionDTO.getCanciones().forEach(
				cancion->cancionPlaylistRepository.registrar(cancion.getId(),
						playlistCancionDTO.getPlaylist().getId()));
		
		return playlistCancionDTO.getPlaylist();
	}

	
	
}
